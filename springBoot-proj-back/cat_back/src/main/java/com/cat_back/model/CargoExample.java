package com.cat_back.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CargoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CargoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andPriceInIsNull() {
            addCriterion("price_in is null");
            return (Criteria) this;
        }

        public Criteria andPriceInIsNotNull() {
            addCriterion("price_in is not null");
            return (Criteria) this;
        }

        public Criteria andPriceInEqualTo(BigDecimal value) {
            addCriterion("price_in =", value, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInNotEqualTo(BigDecimal value) {
            addCriterion("price_in <>", value, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInGreaterThan(BigDecimal value) {
            addCriterion("price_in >", value, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_in >=", value, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInLessThan(BigDecimal value) {
            addCriterion("price_in <", value, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_in <=", value, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInIn(List<BigDecimal> values) {
            addCriterion("price_in in", values, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInNotIn(List<BigDecimal> values) {
            addCriterion("price_in not in", values, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_in between", value1, value2, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceInNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_in not between", value1, value2, "priceIn");
            return (Criteria) this;
        }

        public Criteria andPriceOutIsNull() {
            addCriterion("price_out is null");
            return (Criteria) this;
        }

        public Criteria andPriceOutIsNotNull() {
            addCriterion("price_out is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOutEqualTo(BigDecimal value) {
            addCriterion("price_out =", value, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutNotEqualTo(BigDecimal value) {
            addCriterion("price_out <>", value, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutGreaterThan(BigDecimal value) {
            addCriterion("price_out >", value, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_out >=", value, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutLessThan(BigDecimal value) {
            addCriterion("price_out <", value, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_out <=", value, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutIn(List<BigDecimal> values) {
            addCriterion("price_out in", values, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutNotIn(List<BigDecimal> values) {
            addCriterion("price_out not in", values, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_out between", value1, value2, "priceOut");
            return (Criteria) this;
        }

        public Criteria andPriceOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_out not between", value1, value2, "priceOut");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andPicAddrIsNull() {
            addCriterion("pic_addr is null");
            return (Criteria) this;
        }

        public Criteria andPicAddrIsNotNull() {
            addCriterion("pic_addr is not null");
            return (Criteria) this;
        }

        public Criteria andPicAddrEqualTo(String value) {
            addCriterion("pic_addr =", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrNotEqualTo(String value) {
            addCriterion("pic_addr <>", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrGreaterThan(String value) {
            addCriterion("pic_addr >", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrGreaterThanOrEqualTo(String value) {
            addCriterion("pic_addr >=", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrLessThan(String value) {
            addCriterion("pic_addr <", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrLessThanOrEqualTo(String value) {
            addCriterion("pic_addr <=", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrLike(String value) {
            addCriterion("pic_addr like", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrNotLike(String value) {
            addCriterion("pic_addr not like", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrIn(List<String> values) {
            addCriterion("pic_addr in", values, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrNotIn(List<String> values) {
            addCriterion("pic_addr not in", values, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrBetween(String value1, String value2) {
            addCriterion("pic_addr between", value1, value2, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrNotBetween(String value1, String value2) {
            addCriterion("pic_addr not between", value1, value2, "picAddr");
            return (Criteria) this;
        }

        public Criteria andFinenessIsNull() {
            addCriterion("fineness is null");
            return (Criteria) this;
        }

        public Criteria andFinenessIsNotNull() {
            addCriterion("fineness is not null");
            return (Criteria) this;
        }

        public Criteria andFinenessEqualTo(String value) {
            addCriterion("fineness =", value, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessNotEqualTo(String value) {
            addCriterion("fineness <>", value, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessGreaterThan(String value) {
            addCriterion("fineness >", value, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessGreaterThanOrEqualTo(String value) {
            addCriterion("fineness >=", value, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessLessThan(String value) {
            addCriterion("fineness <", value, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessLessThanOrEqualTo(String value) {
            addCriterion("fineness <=", value, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessLike(String value) {
            addCriterion("fineness like", value, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessNotLike(String value) {
            addCriterion("fineness not like", value, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessIn(List<String> values) {
            addCriterion("fineness in", values, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessNotIn(List<String> values) {
            addCriterion("fineness not in", values, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessBetween(String value1, String value2) {
            addCriterion("fineness between", value1, value2, "fineness");
            return (Criteria) this;
        }

        public Criteria andFinenessNotBetween(String value1, String value2) {
            addCriterion("fineness not between", value1, value2, "fineness");
            return (Criteria) this;
        }

        public Criteria andStoresIdIsNull() {
            addCriterion("stores_id is null");
            return (Criteria) this;
        }

        public Criteria andStoresIdIsNotNull() {
            addCriterion("stores_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoresIdEqualTo(Integer value) {
            addCriterion("stores_id =", value, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdNotEqualTo(Integer value) {
            addCriterion("stores_id <>", value, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdGreaterThan(Integer value) {
            addCriterion("stores_id >", value, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stores_id >=", value, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdLessThan(Integer value) {
            addCriterion("stores_id <", value, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdLessThanOrEqualTo(Integer value) {
            addCriterion("stores_id <=", value, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdIn(List<Integer> values) {
            addCriterion("stores_id in", values, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdNotIn(List<Integer> values) {
            addCriterion("stores_id not in", values, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdBetween(Integer value1, Integer value2) {
            addCriterion("stores_id between", value1, value2, "storesId");
            return (Criteria) this;
        }

        public Criteria andStoresIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stores_id not between", value1, value2, "storesId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}