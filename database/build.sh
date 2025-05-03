#!/bin/bash

# MySQL credentials
USER="root"  # 修改为你的 MySQL 用户名
PASSWORD="your_password"  # 修改为你的 MySQL 密码
HOST="localhost"  # 如果是远程数据库，请修改为相应的主机地址

# 数据库名称
DB_NAME="CIMS"

# 创建数据库
echo "Creating database $DB_NAME..."
mysql -u $USER -p$PASSWORD -h $HOST -e "CREATE DATABASE IF NOT EXISTS $DB_NAME DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;"

# 选择数据库
echo "Using database $DB_NAME..."
mysql -u $USER -p$PASSWORD -h $HOST $DB_NAME < build.sql

echo "Database setup completed!"
