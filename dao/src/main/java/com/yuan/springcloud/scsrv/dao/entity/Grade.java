package com.yuan.springcloud.scsrv.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
*  @author author
*/
public class Grade implements Serializable {

    private static final long serialVersionUID = 1552785304882L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Long id;

    /**
    * 
    * isNullAble:0
    */
    private String user_id;

    /**
    * 
    * isNullAble:0
    */
    private String grade_id;

    /**
    * 
    * isNullAble:0
    */
    private Integer grade_value;


    public void setId(Long id){this.id = id;}

    public Long getId(){return this.id;}

    public void setUser_id(String user_id){this.user_id = user_id;}

    public String getUser_id(){return this.user_id;}

    public void setGrade_id(String grade_id){this.grade_id = grade_id;}

    public String getGrade_id(){return this.grade_id;}

    public void setGrade_value(Integer grade_value){this.grade_value = grade_value;}

    public Integer getGrade_value(){return this.grade_value;}
    @Override
    public String toString() {
        return "grade{" +
                "id='" + id + '\'' +
                "user_id='" + user_id + '\'' +
                "grade_id='" + grade_id + '\'' +
                "grade_value='" + grade_value + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Grade set;

        private ConditionBuilder where;

        public UpdateBuilder set(Grade set){
            this.set = set;
            return this;
        }

        public Grade getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends Grade {
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> user_idList;

        public List<String> getUser_idList(){return this.user_idList;}


        private List<String> fuzzyUser_id;

        public List<String> getFuzzyUser_id(){return this.fuzzyUser_id;}

        private List<String> rightFuzzyUser_id;

        public List<String> getRightFuzzyUser_id(){return this.rightFuzzyUser_id;}
        private List<String> grade_idList;

        public List<String> getGrade_idList(){return this.grade_idList;}


        private List<String> fuzzyGrade_id;

        public List<String> getFuzzyGrade_id(){return this.fuzzyGrade_id;}

        private List<String> rightFuzzyGrade_id;

        public List<String> getRightFuzzyGrade_id(){return this.rightFuzzyGrade_id;}
        private List<Integer> grade_valueList;

        public List<Integer> getGrade_valueList(){return this.grade_valueList;}

        private Integer grade_valueSt;

        private Integer grade_valueEd;

        public Integer getGrade_valueSt(){return this.grade_valueSt;}

        public Integer getGrade_valueEd(){return this.grade_valueEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public QueryBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public QueryBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public QueryBuilder id(Long id){
            setId(id);
            return this;
        }

        public QueryBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public QueryBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public QueryBuilder fetchId(){
            setFetchFields("fetchFields","id");
            return this;
        }

        public QueryBuilder excludeId(){
            setFetchFields("excludeFields","id");
            return this;
        }

        public QueryBuilder fuzzyUser_id (List<String> fuzzyUser_id){
            this.fuzzyUser_id = fuzzyUser_id;
            return this;
        }

        public QueryBuilder fuzzyUser_id (String ... fuzzyUser_id){
            this.fuzzyUser_id = solveNullList(fuzzyUser_id);
            return this;
        }

        public QueryBuilder rightFuzzyUser_id (List<String> rightFuzzyUser_id){
            this.rightFuzzyUser_id = rightFuzzyUser_id;
            return this;
        }

        public QueryBuilder rightFuzzyUser_id (String ... rightFuzzyUser_id){
            this.rightFuzzyUser_id = solveNullList(rightFuzzyUser_id);
            return this;
        }

        public QueryBuilder user_id(String user_id){
            setUser_id(user_id);
            return this;
        }

        public QueryBuilder user_idList(String ... user_id){
            this.user_idList = solveNullList(user_id);
            return this;
        }

        public QueryBuilder user_idList(List<String> user_id){
            this.user_idList = user_id;
            return this;
        }

        public QueryBuilder fetchUser_id(){
            setFetchFields("fetchFields","user_id");
            return this;
        }

        public QueryBuilder excludeUser_id(){
            setFetchFields("excludeFields","user_id");
            return this;
        }

        public QueryBuilder fuzzyGrade_id (List<String> fuzzyGrade_id){
            this.fuzzyGrade_id = fuzzyGrade_id;
            return this;
        }

        public QueryBuilder fuzzyGrade_id (String ... fuzzyGrade_id){
            this.fuzzyGrade_id = solveNullList(fuzzyGrade_id);
            return this;
        }

        public QueryBuilder rightFuzzyGrade_id (List<String> rightFuzzyGrade_id){
            this.rightFuzzyGrade_id = rightFuzzyGrade_id;
            return this;
        }

        public QueryBuilder rightFuzzyGrade_id (String ... rightFuzzyGrade_id){
            this.rightFuzzyGrade_id = solveNullList(rightFuzzyGrade_id);
            return this;
        }

        public QueryBuilder grade_id(String grade_id){
            setGrade_id(grade_id);
            return this;
        }

        public QueryBuilder grade_idList(String ... grade_id){
            this.grade_idList = solveNullList(grade_id);
            return this;
        }

        public QueryBuilder grade_idList(List<String> grade_id){
            this.grade_idList = grade_id;
            return this;
        }

        public QueryBuilder fetchGrade_id(){
            setFetchFields("fetchFields","grade_id");
            return this;
        }

        public QueryBuilder excludeGrade_id(){
            setFetchFields("excludeFields","grade_id");
            return this;
        }

        public QueryBuilder grade_valueBetWeen(Integer grade_valueSt,Integer grade_valueEd){
            this.grade_valueSt = grade_valueSt;
            this.grade_valueEd = grade_valueEd;
            return this;
        }

        public QueryBuilder grade_valueGreaterEqThan(Integer grade_valueSt){
            this.grade_valueSt = grade_valueSt;
            return this;
        }
        public QueryBuilder grade_valueLessEqThan(Integer grade_valueEd){
            this.grade_valueEd = grade_valueEd;
            return this;
        }


        public QueryBuilder grade_value(Integer grade_value){
            setGrade_value(grade_value);
            return this;
        }

        public QueryBuilder grade_valueList(Integer ... grade_value){
            this.grade_valueList = solveNullList(grade_value);
            return this;
        }

        public QueryBuilder grade_valueList(List<Integer> grade_value){
            this.grade_valueList = grade_value;
            return this;
        }

        public QueryBuilder fetchGrade_value(){
            setFetchFields("fetchFields","grade_value");
            return this;
        }

        public QueryBuilder excludeGrade_value(){
            setFetchFields("excludeFields","grade_value");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public Grade build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Long> idList;

        public List<Long> getIdList(){return this.idList;}

        private Long idSt;

        private Long idEd;

        public Long getIdSt(){return this.idSt;}

        public Long getIdEd(){return this.idEd;}

        private List<String> user_idList;

        public List<String> getUser_idList(){return this.user_idList;}


        private List<String> fuzzyUser_id;

        public List<String> getFuzzyUser_id(){return this.fuzzyUser_id;}

        private List<String> rightFuzzyUser_id;

        public List<String> getRightFuzzyUser_id(){return this.rightFuzzyUser_id;}
        private List<String> grade_idList;

        public List<String> getGrade_idList(){return this.grade_idList;}


        private List<String> fuzzyGrade_id;

        public List<String> getFuzzyGrade_id(){return this.fuzzyGrade_id;}

        private List<String> rightFuzzyGrade_id;

        public List<String> getRightFuzzyGrade_id(){return this.rightFuzzyGrade_id;}
        private List<Integer> grade_valueList;

        public List<Integer> getGrade_valueList(){return this.grade_valueList;}

        private Integer grade_valueSt;

        private Integer grade_valueEd;

        public Integer getGrade_valueSt(){return this.grade_valueSt;}

        public Integer getGrade_valueEd(){return this.grade_valueEd;}


        public ConditionBuilder idBetWeen(Long idSt,Long idEd){
            this.idSt = idSt;
            this.idEd = idEd;
            return this;
        }

        public ConditionBuilder idGreaterEqThan(Long idSt){
            this.idSt = idSt;
            return this;
        }
        public ConditionBuilder idLessEqThan(Long idEd){
            this.idEd = idEd;
            return this;
        }


        public ConditionBuilder idList(Long ... id){
            this.idList = solveNullList(id);
            return this;
        }

        public ConditionBuilder idList(List<Long> id){
            this.idList = id;
            return this;
        }

        public ConditionBuilder fuzzyUser_id (List<String> fuzzyUser_id){
            this.fuzzyUser_id = fuzzyUser_id;
            return this;
        }

        public ConditionBuilder fuzzyUser_id (String ... fuzzyUser_id){
            this.fuzzyUser_id = solveNullList(fuzzyUser_id);
            return this;
        }

        public ConditionBuilder rightFuzzyUser_id (List<String> rightFuzzyUser_id){
            this.rightFuzzyUser_id = rightFuzzyUser_id;
            return this;
        }

        public ConditionBuilder rightFuzzyUser_id (String ... rightFuzzyUser_id){
            this.rightFuzzyUser_id = solveNullList(rightFuzzyUser_id);
            return this;
        }

        public ConditionBuilder user_idList(String ... user_id){
            this.user_idList = solveNullList(user_id);
            return this;
        }

        public ConditionBuilder user_idList(List<String> user_id){
            this.user_idList = user_id;
            return this;
        }

        public ConditionBuilder fuzzyGrade_id (List<String> fuzzyGrade_id){
            this.fuzzyGrade_id = fuzzyGrade_id;
            return this;
        }

        public ConditionBuilder fuzzyGrade_id (String ... fuzzyGrade_id){
            this.fuzzyGrade_id = solveNullList(fuzzyGrade_id);
            return this;
        }

        public ConditionBuilder rightFuzzyGrade_id (List<String> rightFuzzyGrade_id){
            this.rightFuzzyGrade_id = rightFuzzyGrade_id;
            return this;
        }

        public ConditionBuilder rightFuzzyGrade_id (String ... rightFuzzyGrade_id){
            this.rightFuzzyGrade_id = solveNullList(rightFuzzyGrade_id);
            return this;
        }

        public ConditionBuilder grade_idList(String ... grade_id){
            this.grade_idList = solveNullList(grade_id);
            return this;
        }

        public ConditionBuilder grade_idList(List<String> grade_id){
            this.grade_idList = grade_id;
            return this;
        }

        public ConditionBuilder grade_valueBetWeen(Integer grade_valueSt,Integer grade_valueEd){
            this.grade_valueSt = grade_valueSt;
            this.grade_valueEd = grade_valueEd;
            return this;
        }

        public ConditionBuilder grade_valueGreaterEqThan(Integer grade_valueSt){
            this.grade_valueSt = grade_valueSt;
            return this;
        }
        public ConditionBuilder grade_valueLessEqThan(Integer grade_valueEd){
            this.grade_valueEd = grade_valueEd;
            return this;
        }


        public ConditionBuilder grade_valueList(Integer ... grade_value){
            this.grade_valueList = solveNullList(grade_value);
            return this;
        }

        public ConditionBuilder grade_valueList(List<Integer> grade_value){
            this.grade_valueList = grade_value;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private Grade obj;

        public Builder(){
            this.obj = new Grade();
        }

        public Builder id(Long id){
            this.obj.setId(id);
            return this;
        }
        public Builder user_id(String user_id){
            this.obj.setUser_id(user_id);
            return this;
        }
        public Builder grade_id(String grade_id){
            this.obj.setGrade_id(grade_id);
            return this;
        }
        public Builder grade_value(Integer grade_value){
            this.obj.setGrade_value(grade_value);
            return this;
        }
        public Grade build(){return obj;}
    }

}
