'use strict';
const db = uniCloud.database();
exports.main = async (event, context) => {
  const { id } = event; // 从事件中获取传入的id
  if (!id) {
    return {
      code: 400,
      message: '缺少id参数'
    };
  }
  
  try {
    const collection = db.collection('type');
    const res = await collection.doc(id).get();
    
    if (res.data && res.data.length > 0) {
      return {
        code: 200,
        data: res.data[0].type // 返回品类名
      };
    } else {
      return {
        code: 404,
        message: '未找到对应的品类'
      };
    }
  } catch (error) {
    return {
      code: 500,
      message: '数据库查询错误',
      error: error.message
    };
  }
};
