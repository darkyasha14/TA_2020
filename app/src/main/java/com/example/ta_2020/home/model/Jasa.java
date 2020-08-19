package com.example.ta_2020.home.model;

import java.util.List;

public class Jasa {

    /**
     * code : 0
     * message : Successfully get sub_category by id
     * data : [{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z","Jasas":[{"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z"},{"jasa_id":2,"sub_category_id":1,"jasa_name":"jasa test 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:08.000Z","updatedAt":"2020-08-17T15:44:08.000Z"}],"Category":{"category_id":1,"category_name":"CATEGORY 1","category_desc":"test desc","createdAt":"2020-08-17T15:37:30.000Z","updatedAt":"2020-08-17T15:37:30.000Z"}}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sub_category_id : 1
         * category_id : 1
         * sub_category_name : sub category 1
         * sub_category_desc : test desc
         * img_url : https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png
         * createdAt : 2020-08-17T15:39:39.000Z
         * updatedAt : 2020-08-17T15:39:39.000Z
         * Jasas : [{"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z"},{"jasa_id":2,"sub_category_id":1,"jasa_name":"jasa test 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:08.000Z","updatedAt":"2020-08-17T15:44:08.000Z"}]
         * Category : {"category_id":1,"category_name":"CATEGORY 1","category_desc":"test desc","createdAt":"2020-08-17T15:37:30.000Z","updatedAt":"2020-08-17T15:37:30.000Z"}
         */

        private int sub_category_id;
        private int category_id;
        private String sub_category_name;
        private String sub_category_desc;
        private String img_url;
        private String createdAt;
        private String updatedAt;
        private CategoryBean Category;
        private List<JasasBean> Jasas;

        public int getSub_category_id() {
            return sub_category_id;
        }

        public void setSub_category_id(int sub_category_id) {
            this.sub_category_id = sub_category_id;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getSub_category_name() {
            return sub_category_name;
        }

        public void setSub_category_name(String sub_category_name) {
            this.sub_category_name = sub_category_name;
        }

        public String getSub_category_desc() {
            return sub_category_desc;
        }

        public void setSub_category_desc(String sub_category_desc) {
            this.sub_category_desc = sub_category_desc;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public CategoryBean getCategory() {
            return Category;
        }

        public void setCategory(CategoryBean Category) {
            this.Category = Category;
        }

        public List<JasasBean> getJasas() {
            return Jasas;
        }

        public void setJasas(List<JasasBean> Jasas) {
            this.Jasas = Jasas;
        }

        public static class CategoryBean {
            /**
             * category_id : 1
             * category_name : CATEGORY 1
             * category_desc : test desc
             * createdAt : 2020-08-17T15:37:30.000Z
             * updatedAt : 2020-08-17T15:37:30.000Z
             */

            private int category_id;
            private String category_name;
            private String category_desc;
            private String createdAt;
            private String updatedAt;

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getCategory_desc() {
                return category_desc;
            }

            public void setCategory_desc(String category_desc) {
                this.category_desc = category_desc;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }

        public static class JasasBean {
            /**
             * jasa_id : 1
             * sub_category_id : 1
             * jasa_name : jasa test 1
             * jasa_desc : test desc 123
             * jasa_price : 10000
             * createdAt : 2020-08-17T15:44:00.000Z
             * updatedAt : 2020-08-17T15:44:00.000Z
             */

            private int jasa_id;
            private int sub_category_id;
            private String jasa_name;
            private String jasa_desc;
            private int jasa_price;
            private String createdAt;
            private String updatedAt;

            public int getJasa_id() {
                return jasa_id;
            }

            public void setJasa_id(int jasa_id) {
                this.jasa_id = jasa_id;
            }

            public int getSub_category_id() {
                return sub_category_id;
            }

            public void setSub_category_id(int sub_category_id) {
                this.sub_category_id = sub_category_id;
            }

            public String getJasa_name() {
                return jasa_name;
            }

            public void setJasa_name(String jasa_name) {
                this.jasa_name = jasa_name;
            }

            public String getJasa_desc() {
                return jasa_desc;
            }

            public void setJasa_desc(String jasa_desc) {
                this.jasa_desc = jasa_desc;
            }

            public int getJasa_price() {
                return jasa_price;
            }

            public void setJasa_price(int jasa_price) {
                this.jasa_price = jasa_price;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}
