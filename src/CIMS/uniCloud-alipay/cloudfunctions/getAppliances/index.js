'use strict';
const db = uniCloud.database();
exports.main = async (event, context) => {
  const { page = 1, pageSize = 20 } = event; // 获取分页参数，默认第一页，每页20条记录
  const skip = (page - 1) * pageSize;

  try {
    const collection = db.collection('goods');
    const res = await collection.skip(skip).limit(pageSize).get();
    return {
      code: 0,
      data: res.data,
      message: 'Query successful',
      currentPage: page,
      pageSize: pageSize,
      total: res.affectedDocs
    };
  } catch (error) {
    return {
      code: 1,
      message: 'Query failed',
      error: error.message
    };
  }
};
