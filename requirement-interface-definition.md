
# 📘 业务需求与接口定义文档

## ✅ 公共说明

* 所有接口中，带注释 `// 2S` 表示客户端 → 服务器端请求数据结构
* `// 2C` 表示服务器端 → 客户端返回数据结构
* 所有字段均为小驼峰命名（`camelCase`）
* `nullable` 表示该字段可以为 `null` 或不传

---

## 👤 用户账户模块

### 📝 用户注册

```jsonc
{ // 2S
  "username": "string",
  "password": "string",
  "phoneNumber": "string",
  "verifyCode": "string",
  "email": "string" // nullable
}
```

### 🔐 用户登录

#### 用户名 + 密码登录

```jsonc
{ // 2S
  "username": "string",
  "password": "string"
}
```

#### 手机号 + 密码登录

```jsonc
{ // 2S
  "phoneNumber": "string",
  "password": "string"
}
```

#### 手机号 + 验证码登录

```jsonc
{ // 2S
  "phoneNumber": "string",
  "verifyCode": "string"
}
```

#### 登录响应

```jsonc
{ // 2C
  "isSuccess": true,
  "jwtToken": "string", // nullable
  "reason": "string"
}
```

### 👁‍🗨 获取用户信息

```jsonc
{ // 2S
  "jwtToken": "string"
}
```

```jsonc
{ // 2C
  "username": "string",
  "passwordSecurity": "easy" | "normal" | "hard",
  "headPicUrl": "string"
}
```

### 🚪 用户登出

```jsonc
{ // 2S
  "jwtToken": "string"
}
```

### 🛠 修改个人信息

#### 修改手机号码

```jsonc
{ // 2S
  "jwtToken": "string",
  "newPhoneNumber": "string",
  "oldPhoneNumber": "string",
  "password": "string"
}
```

#### 修改密码

* 通过旧密码：

```jsonc
{ // 2S
  "jwtToken": "string",
  "oldPassword": "string",
  "newPassword": "string"
}
```

* 通过手机号 + 验证码：

```jsonc
{ // 2S
  "jwtToken": "string",
  "newPassword": "string",
  "verifyCode": "string"
}
```

* 忘记密码：

```jsonc
{ // 2S
  "phoneNumber": "string",
  "newPassword": "string",
  "verifyCode": "string"
}
```

通用响应：

```jsonc
{ // 2C
  "isSuccess": true,
  "reason": "string"
}
```

#### 修改用户名

* 手机号 + 密码：

```jsonc
{ // 2S
  "phoneNumber": "string",
  "password": "string",
  "newUsername": "string"
}
```

* 手机号 + 验证码：

```jsonc
{ // 2S
  "phoneNumber": "string",
  "verifyCode": "string",
  "newUsername": "string"
}
```

#### 修改邮箱

* 手机号 + 密码：

```jsonc
{ // 2S
  "phoneNumber": "string",
  "password": "string",
  "newEmail": "string"
}
```

* 手机号 + 验证码：

```jsonc
{ // 2S
  "phoneNumber": "string",
  "verifyCode": "string",
  "newEmail": "string"
}
```

---

## 🏬 店铺管理模块

### 🏠 店铺注册

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopName": "string",
  "shopAddress": ["string"],
  "shopPhone": "string"
}
```

```jsonc
{ // 2C
  "isSuccess": true,
  "shopId": "string",
  "reason": "string"
}
```

### ➕ 添加店铺人员

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopId": "string",
  "phoneNumber": "string",
  "role": "manager" | "staff"
}
```

### 🔁 转让店铺经理权限

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopId": "string",
  "newManagerPhone": "string",
  "verifyCodeOld": "string",
  "verifyCodeNew": "string"
}
```

### 📊 店铺统计数据

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopId": "string",
  "startDate": "YYYY-MM-DD",
  "endDate": "YYYY-MM-DD"
}
```

```jsonc
{ // 2C
  "totalOrders": 0,
  "totalRevenue": 0.0,
  "totalGoods": 0,
  "dailyStats": [
    {
      "date": "YYYY-MM-DD",
      "orders": 0,
      "revenue": 0.0
    }
  ]
}
```

### ❌ 清退店铺人员

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopId": "string",
  "staffPhone": "string",
  "verifyCode": "string"
}
```

---

## 📦 货物管理模块

### ➕ 新增货物

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopId": "string",
  "goodsName": "string",
  "goodsType": "string",
  "goodsBrand": "string",
  "quantity": -1 | 1 | 2 | 3 | 4 | 5,
  "inPrice": 0.0,
  "description": "string",
  "address": "string",
  "images": ["string"]
}
```

```jsonc
{ // 2C
  "isSuccess": true,
  "goodsId": "string",
  "reason": "string",
  "goods": {
    "goodsId": "string",
    "goodsName": "string",
    "goodsType": "string",
    "goodsBrand": "string",
    "quantity": 1,
    "inPrice": 0.0,
    "description": "string",
    "address": "string",
    "images": ["string"],
    "lastUpdateTime": "YYYY-MM-DD HH:mm:ss"
  }
}
```

### 🔍 条件查询货物

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopId": "string",
  "goodsName": "string", // nullable
  "goodsType": "string", // nullable
  "goodsBrand": "string", // nullable
  "quantity": -1 | 1 | 2 | 3 | 4 | 5, // nullable
  "page": 1,
  "pageSize": 10
}
```

```jsonc
{ // 2C
  "total": 0,
  "goods": [ ... ]
}
```

---

## 📑 订单管理模块

### 🧾 创建入库订单

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopId": "string",
  "goods": [
    {
      "goodsName": "string",
      "quantity": 0,
      "unitPrice": 0.0
    }
  ],
  "supplier": "string",
  "expectedArrivalTime": "YYYY-MM-DD"
}
```

```jsonc
{ // 2C
  "isSuccess": true,
  "orderId": "string",
  "reason": "string"
}
```

### 📤 创建出库订单

```jsonc
{ // 2S
  "jwtToken": "string",
  "shopId": "string",
  "goods": [
    {
      "goodsId": "string",
      "quantity": 0
    }
  ],
  "customer": "string",
  "deliveryAddress": "string"
}
```

---


## 🖼 图片服务接口

### 📤 上传图片

```jsonc
// 请求类型：multipart/form-data
POST /api/image/upload

字段：
- jwtToken: string （可放入 Header 或表单字段）
- file: 文件（图片文件）

响应：
{
  "isSuccess": true,
  "imageUrl": "/static/uploads/2025/05/03/abc123.jpg",
  "reason": "string"
}

```

> ✅ 说明：
> - 图片存储路径如 /static/uploads/YYYY/MM/DD/filename.jpg。
> - imageUrl 是相对路径，前端可拼接服务器域名用于访问。
> - 服务器需确保 /static/uploads 可被 Web 访问。
---



## 🔐 验证码服务接口

### 📩 发送验证码（支持注册、登录、修改信息等用途）

```jsonc
{ // 2S
  "phoneNumber": "string",
  "purpose": "register" | "login" | "changePassword" | "changePhone" | "changeUsername" | "changeEmail"
}
```

```jsonc
{ // 2C
  "isSuccess": true,
  "reason": "string"
}
```

> ✅ **说明**：
>
> * `purpose` 用于服务端判断验证码用途和防刷策略。
> * 可加验证码频率限制，如：同手机号每分钟最多请求 1 次。

---

### ✅ 校验验证码

```jsonc
{ // 2S
  "phoneNumber": "string",
  "verifyCode": "string",
  "purpose": "register" | "login" | "changePassword" | "changePhone" | "changeUsername" | "changeEmail"
}
```

```jsonc
{ // 2C
  "isValid": true,
  "reason": "string"
}
```
