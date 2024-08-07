# JQL学习笔记

JQL（JavaScript Query Language）是一种用于查询云数据库的语言，常用于小程序、uni-app等云开发平台。JQL与SQL（Structured Query Language）在功能上有相似之处，但在语法上有显著差异，因为JQL的设计目标是更适应JavaScript环境和云数据库的特点。

以下是JQL与SQL的一些对应关系及其示例：

### 基本查询
**SQL:**
```sql
SELECT * FROM users WHERE age > 18;
```
**JQL:**
```javascript
db.collection('users').where({
  age: _.gt(18)
}).get()
```

### 插入数据
**SQL:**
```sql
INSERT INTO users (name, age) VALUES ('John', 25);
```
**JQL:**
```javascript
db.collection('users').add({
  data: {
    name: 'John',
    age: 25
  }
})
```

### 更新数据
**SQL:**
```sql
UPDATE users SET age = 26 WHERE name = 'John';
```
**JQL:**
```javascript
db.collection('users').where({
  name: 'John'
}).update({
  data: {
    age: 26
  }
})
```

### 删除数据
**SQL:**
```sql
DELETE FROM users WHERE age < 18;
```
**JQL:**
```javascript
db.collection('users').where({
  age: _.lt(18)
}).remove()
```

### 查询排序
**SQL:**
```sql
SELECT * FROM users ORDER BY age DESC;
```
**JQL:**
```javascript
db.collection('users').orderBy('age', 'desc').get()
```

### 查询限制和偏移
**SQL:**
```sql
SELECT * FROM users LIMIT 10 OFFSET 5;
```
**JQL:**
```javascript
db.collection('users').skip(5).limit(10).get()
```

### 聚合查询
**SQL:**
```sql
SELECT age, COUNT(*) FROM users GROUP BY age;
```
**JQL:**
```javascript
db.collection('users').aggregate()
  .group({
    _id: '$age',
    count: $.sum(1)
  }).end()
```

### 连接查询
JQL 不直接支持 SQL 中的 JOIN 操作，但可以通过多次查询和数据处理来实现类似的功能。 

### 示例：
假设你有两个集合，一个是 `users`，另一个是 `orders`，你想要查询所有用户及其订单：

1. 首先查询用户集合：
```javascript
let users = await db.collection('users').get()
```

2. 然后根据用户ID查询每个用户的订单：
```javascript
for (let user of users.data) {
  let orders = await db.collection('orders').where({
    userId: user._id
  }).get()
  user.orders = orders.data
}
```

这种方式虽然较为繁琐，但能达到类似SQL JOIN的效果。
