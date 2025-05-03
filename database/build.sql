-- 使用数据库
USE `CIMS`;

-- 用户账户模块
CREATE TABLE IF NOT EXISTS `user` (
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

-- 店铺管理模块
CREATE TABLE IF NOT EXISTS `shop` (
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

-- 货物管理模块
CREATE TABLE IF NOT EXISTS `goods` (
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

-- 索引定义

-- 用户模块索引
ALTER TABLE `user`
  ADD UNIQUE INDEX `idx_user_username` (`username`),
  ADD UNIQUE INDEX `idx_user_phone_number` (`phone_number`);

-- 店铺模块索引
ALTER TABLE `shop`
  ADD INDEX `idx_owner_id` (`owner_id`);

-- 货物模块索引
ALTER TABLE `goods`
  ADD INDEX `idx_shop_id` (`shop_id`),
  ADD INDEX `idx_goods_name` (`goods_name`),
  ADD INDEX `idx_goods_type` (`goods_type`),
  ADD INDEX `idx_last_update_time` (`last_update_time`);
