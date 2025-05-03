# MySQL 数据库定义文档


## 📂 数据库名（建议）：

```sql
CREATE DATABASE IF NOT EXISTS `CIMS` DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
USE `CIMS`;
```

---

## 👤 用户账户模块

```sql
CREATE TABLE `user` (
  `user_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `username` VARCHAR(50) NOT NULL UNIQUE,
  `password_hashed` VARCHAR(100) NOT NULL,
  `hash_code` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL UNIQUE,
  `email` VARCHAR(100),
  `head_pic_url` TEXT,
  `password_security` ENUM('easy', 'normal', 'hard') DEFAULT 'easy',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 🏬 店铺管理模块

```sql
CREATE TABLE `shop` (
  `shop_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `shop_name` VARCHAR(100) NOT NULL UNIQUE,
  `shop_address` TEXT NOT NULL,
  `province` VARCHAR(50),
  `city` VARCHAR(50),
  `district` VARCHAR(50),
  `detail_address` VARCHAR(200),
  `shop_phone` VARCHAR(20),
  `owner_id` BIGINT NOT NULL,  -- 作为店铺管理员
  `is_deleted` BOOLEAN DEFAULT FALSE,  -- 软删除标识
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`owner_id`) REFERENCES `user`(`user_id`)
);

```

---

## 📦 货物管理模块

```sql
CREATE TABLE `goods` (
  `goods_id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `shop_id` BIGINT NOT NULL,
  `goods_name` VARCHAR(100) NOT NULL,
  `goods_type` VARCHAR(50),
  `goods_brand` VARCHAR(50),
  `quantity` INT NOT NULL,
  `in_price` DECIMAL(10, 2),
  `description` TEXT,
  `address` VARCHAR(200),
  `image_urls` TEXT, -- 用 JSON 字符串分隔 URL
  `last_update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (`shop_id`) REFERENCES `shop`(`shop_id`) ON DELETE CASCADE
);
```



## 索引

#### **用户模块**

**业务操作：** 登录（用户名/手机号）、查重（用户名/手机号）

```sql
ALTER TABLE `user`
  ADD UNIQUE INDEX `idx_user_username` (`username`),
  ADD UNIQUE INDEX `idx_user_phone_number` (`phone_number`);

```

---

#### **店铺模块**

**业务操作：**

* 查询用户所有店铺
* 查询店铺员工列表
* 通过 `user_id` 查找是否有角色（权限管理）

```sql
ALTER TABLE `shop`
  ADD INDEX `idx_owner_id` (`owner_id`);

ALTER TABLE `shop_staff`
  ADD INDEX `idx_user_id` (`user_id`),
  ADD INDEX `idx_shop_id` (`shop_id`),
  ADD UNIQUE INDEX `uk_shop_user` (`shop_id`, `user_id`);
```

---

#### **货物模块**

**业务操作：**

* 某个店铺的货物列表
* 根据名字或类型快速搜索
* 按最后更新时间排序
* 展示商品图片

```sql
ALTER TABLE `goods`
  ADD INDEX `idx_shop_id` (`shop_id`),
  ADD INDEX `idx_goods_name` (`goods_name`),
  ADD INDEX `idx_goods_type` (`goods_type`),
  ADD INDEX `idx_last_update_time` (`last_update_time`);
```


