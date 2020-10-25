package com.anue.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StockPriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockPriceExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andPriceidIsNull() {
            addCriterion("priceId is null");
            return (Criteria) this;
        }

        public Criteria andPriceidIsNotNull() {
            addCriterion("priceId is not null");
            return (Criteria) this;
        }

        public Criteria andPriceidEqualTo(Integer value) {
            addCriterion("priceId =", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotEqualTo(Integer value) {
            addCriterion("priceId <>", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidGreaterThan(Integer value) {
            addCriterion("priceId >", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("priceId >=", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLessThan(Integer value) {
            addCriterion("priceId <", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLessThanOrEqualTo(Integer value) {
            addCriterion("priceId <=", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidIn(List<Integer> values) {
            addCriterion("priceId in", values, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotIn(List<Integer> values) {
            addCriterion("priceId not in", values, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidBetween(Integer value1, Integer value2) {
            addCriterion("priceId between", value1, value2, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotBetween(Integer value1, Integer value2) {
            addCriterion("priceId not between", value1, value2, "priceid");
            return (Criteria) this;
        }

        public Criteria andFkStockidIsNull() {
            addCriterion("fk_stockId is null");
            return (Criteria) this;
        }

        public Criteria andFkStockidIsNotNull() {
            addCriterion("fk_stockId is not null");
            return (Criteria) this;
        }

        public Criteria andFkStockidEqualTo(Integer value) {
            addCriterion("fk_stockId =", value, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidNotEqualTo(Integer value) {
            addCriterion("fk_stockId <>", value, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidGreaterThan(Integer value) {
            addCriterion("fk_stockId >", value, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_stockId >=", value, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidLessThan(Integer value) {
            addCriterion("fk_stockId <", value, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidLessThanOrEqualTo(Integer value) {
            addCriterion("fk_stockId <=", value, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidIn(List<Integer> values) {
            addCriterion("fk_stockId in", values, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidNotIn(List<Integer> values) {
            addCriterion("fk_stockId not in", values, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidBetween(Integer value1, Integer value2) {
            addCriterion("fk_stockId between", value1, value2, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andFkStockidNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_stockId not between", value1, value2, "fkStockid");
            return (Criteria) this;
        }

        public Criteria andTransdateIsNull() {
            addCriterion("transDate is null");
            return (Criteria) this;
        }

        public Criteria andTransdateIsNotNull() {
            addCriterion("transDate is not null");
            return (Criteria) this;
        }

        public Criteria andTransdateEqualTo(Date value) {
            addCriterionForJDBCDate("transDate =", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("transDate <>", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateGreaterThan(Date value) {
            addCriterionForJDBCDate("transDate >", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("transDate >=", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateLessThan(Date value) {
            addCriterionForJDBCDate("transDate <", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("transDate <=", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateIn(List<Date> values) {
            addCriterionForJDBCDate("transDate in", values, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("transDate not in", values, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("transDate between", value1, value2, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("transDate not between", value1, value2, "transdate");
            return (Criteria) this;
        }

        public Criteria andTranstimeIsNull() {
            addCriterion("transTime is null");
            return (Criteria) this;
        }

        public Criteria andTranstimeIsNotNull() {
            addCriterion("transTime is not null");
            return (Criteria) this;
        }

        public Criteria andTranstimeEqualTo(Date value) {
            addCriterionForJDBCTime("transTime =", value, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("transTime <>", value, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeGreaterThan(Date value) {
            addCriterionForJDBCTime("transTime >", value, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("transTime >=", value, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeLessThan(Date value) {
            addCriterionForJDBCTime("transTime <", value, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("transTime <=", value, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeIn(List<Date> values) {
            addCriterionForJDBCTime("transTime in", values, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("transTime not in", values, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("transTime between", value1, value2, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranstimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("transTime not between", value1, value2, "transtime");
            return (Criteria) this;
        }

        public Criteria andTranspriceIsNull() {
            addCriterion("transPrice is null");
            return (Criteria) this;
        }

        public Criteria andTranspriceIsNotNull() {
            addCriterion("transPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTranspriceEqualTo(Integer value) {
            addCriterion("transPrice =", value, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceNotEqualTo(Integer value) {
            addCriterion("transPrice <>", value, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceGreaterThan(Integer value) {
            addCriterion("transPrice >", value, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("transPrice >=", value, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceLessThan(Integer value) {
            addCriterion("transPrice <", value, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceLessThanOrEqualTo(Integer value) {
            addCriterion("transPrice <=", value, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceIn(List<Integer> values) {
            addCriterion("transPrice in", values, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceNotIn(List<Integer> values) {
            addCriterion("transPrice not in", values, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceBetween(Integer value1, Integer value2) {
            addCriterion("transPrice between", value1, value2, "transprice");
            return (Criteria) this;
        }

        public Criteria andTranspriceNotBetween(Integer value1, Integer value2) {
            addCriterion("transPrice not between", value1, value2, "transprice");
            return (Criteria) this;
        }

        public Criteria andTransquantityIsNull() {
            addCriterion("transQuantity is null");
            return (Criteria) this;
        }

        public Criteria andTransquantityIsNotNull() {
            addCriterion("transQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andTransquantityEqualTo(Integer value) {
            addCriterion("transQuantity =", value, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityNotEqualTo(Integer value) {
            addCriterion("transQuantity <>", value, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityGreaterThan(Integer value) {
            addCriterion("transQuantity >", value, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("transQuantity >=", value, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityLessThan(Integer value) {
            addCriterion("transQuantity <", value, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityLessThanOrEqualTo(Integer value) {
            addCriterion("transQuantity <=", value, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityIn(List<Integer> values) {
            addCriterion("transQuantity in", values, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityNotIn(List<Integer> values) {
            addCriterion("transQuantity not in", values, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityBetween(Integer value1, Integer value2) {
            addCriterion("transQuantity between", value1, value2, "transquantity");
            return (Criteria) this;
        }

        public Criteria andTransquantityNotBetween(Integer value1, Integer value2) {
            addCriterion("transQuantity not between", value1, value2, "transquantity");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
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