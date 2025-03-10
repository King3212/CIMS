package com.cat_back.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
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

        public Criteria andLocalHashIsNull() {
            addCriterion("local_hash is null");
            return (Criteria) this;
        }

        public Criteria andLocalHashIsNotNull() {
            addCriterion("local_hash is not null");
            return (Criteria) this;
        }

        public Criteria andLocalHashEqualTo(String value) {
            addCriterion("local_hash =", value, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashNotEqualTo(String value) {
            addCriterion("local_hash <>", value, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashGreaterThan(String value) {
            addCriterion("local_hash >", value, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashGreaterThanOrEqualTo(String value) {
            addCriterion("local_hash >=", value, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashLessThan(String value) {
            addCriterion("local_hash <", value, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashLessThanOrEqualTo(String value) {
            addCriterion("local_hash <=", value, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashLike(String value) {
            addCriterion("local_hash like", value, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashNotLike(String value) {
            addCriterion("local_hash not like", value, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashIn(List<String> values) {
            addCriterion("local_hash in", values, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashNotIn(List<String> values) {
            addCriterion("local_hash not in", values, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashBetween(String value1, String value2) {
            addCriterion("local_hash between", value1, value2, "localHash");
            return (Criteria) this;
        }

        public Criteria andLocalHashNotBetween(String value1, String value2) {
            addCriterion("local_hash not between", value1, value2, "localHash");
            return (Criteria) this;
        }

        public Criteria andRandomCodeIsNull() {
            addCriterion("random_code is null");
            return (Criteria) this;
        }

        public Criteria andRandomCodeIsNotNull() {
            addCriterion("random_code is not null");
            return (Criteria) this;
        }

        public Criteria andRandomCodeEqualTo(String value) {
            addCriterion("random_code =", value, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeNotEqualTo(String value) {
            addCriterion("random_code <>", value, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeGreaterThan(String value) {
            addCriterion("random_code >", value, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeGreaterThanOrEqualTo(String value) {
            addCriterion("random_code >=", value, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeLessThan(String value) {
            addCriterion("random_code <", value, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeLessThanOrEqualTo(String value) {
            addCriterion("random_code <=", value, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeLike(String value) {
            addCriterion("random_code like", value, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeNotLike(String value) {
            addCriterion("random_code not like", value, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeIn(List<String> values) {
            addCriterion("random_code in", values, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeNotIn(List<String> values) {
            addCriterion("random_code not in", values, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeBetween(String value1, String value2) {
            addCriterion("random_code between", value1, value2, "randomCode");
            return (Criteria) this;
        }

        public Criteria andRandomCodeNotBetween(String value1, String value2) {
            addCriterion("random_code not between", value1, value2, "randomCode");
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