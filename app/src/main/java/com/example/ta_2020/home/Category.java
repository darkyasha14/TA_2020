package com.example.ta_2020.home;

import java.util.List;

public class Category {

    /**
     * code : 0
     * message : successs get list category
     * data : [{"category_id":1,"category_name":"category 1","category_desc":"test desc","createdAt":"2020-08-17T15:37:30.000Z","updatedAt":"2020-08-17T15:37:30.000Z","Sub_categories":[{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z","Jasas":[{"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z"},{"jasa_id":2,"sub_category_id":1,"jasa_name":"jasa test 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:08.000Z","updatedAt":"2020-08-17T15:44:08.000Z"}]},{"sub_category_id":2,"category_id":1,"sub_category_name":"sub category 2","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-2.png","createdAt":"2020-08-17T15:40:21.000Z","updatedAt":"2020-08-17T15:40:21.000Z","Jasas":[{"jasa_id":3,"sub_category_id":2,"jasa_name":"jasa name 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:24.000Z","updatedAt":"2020-08-17T15:44:24.000Z"},{"jasa_id":4,"sub_category_id":2,"jasa_name":"jasa name 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:29.000Z","updatedAt":"2020-08-17T15:44:29.000Z"}]},{"sub_category_id":4,"category_id":1,"sub_category_name":"sub category 3","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-3.png","createdAt":"2020-08-17T15:40:35.000Z","updatedAt":"2020-08-17T15:40:35.000Z","Jasas":[{"jasa_id":7,"sub_category_id":4,"jasa_name":"jasa name","jasa_desc":"test desc","jasa_price":10000,"createdAt":"2020-08-17T15:48:03.000Z","updatedAt":"2020-08-17T15:48:03.000Z"}]},{"sub_category_id":5,"category_id":1,"sub_category_name":"sub category 4","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-4.png","createdAt":"2020-08-17T15:40:40.000Z","updatedAt":"2020-08-17T15:40:40.000Z","Jasas":[{"jasa_id":8,"sub_category_id":5,"jasa_name":"name1","jasa_desc":"test desc","jasa_price":10008,"createdAt":"2020-08-17T15:48:29.000Z","updatedAt":"2020-08-17T15:48:29.000Z"},{"jasa_id":9,"sub_category_id":5,"jasa_name":"name2","jasa_desc":"test desc","jasa_price":10008,"createdAt":"2020-08-17T15:48:35.000Z","updatedAt":"2020-08-17T15:48:35.000Z"}]}]},{"category_id":2,"category_name":"category 2","category_desc":"test desc","createdAt":"2020-08-17T15:37:58.000Z","updatedAt":"2020-08-17T15:37:58.000Z","Sub_categories":[{"sub_category_id":8,"category_id":2,"sub_category_name":"sub category t1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-t1.png","createdAt":"2020-08-17T15:41:44.000Z","updatedAt":"2020-08-17T15:41:44.000Z","Jasas":[{"jasa_id":13,"sub_category_id":8,"jasa_name":"name3","jasa_desc":"test desc","jasa_price":10008,"createdAt":"2020-08-17T15:49:34.000Z","updatedAt":"2020-08-17T15:49:34.000Z"}]},{"sub_category_id":9,"category_id":2,"sub_category_name":"sub category t2","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-t2.png","createdAt":"2020-08-17T15:41:53.000Z","updatedAt":"2020-08-17T15:41:53.000Z","Jasas":[{"jasa_id":14,"sub_category_id":9,"jasa_name":"name4","jasa_desc":"test desc","jasa_price":10008,"createdAt":"2020-08-17T15:49:43.000Z","updatedAt":"2020-08-17T15:49:43.000Z"}]},{"sub_category_id":10,"category_id":2,"sub_category_name":"sub category t3","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-t3.png","createdAt":"2020-08-17T15:41:58.000Z","updatedAt":"2020-08-17T15:41:58.000Z","Jasas":[]}]}]
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
         * category_id : 1
         * category_name : category 1
         * category_desc : test desc
         * createdAt : 2020-08-17T15:37:30.000Z
         * updatedAt : 2020-08-17T15:37:30.000Z
         * Sub_categories : [{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z","Jasas":[{"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z"},{"jasa_id":2,"sub_category_id":1,"jasa_name":"jasa test 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:08.000Z","updatedAt":"2020-08-17T15:44:08.000Z"}]},{"sub_category_id":2,"category_id":1,"sub_category_name":"sub category 2","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-2.png","createdAt":"2020-08-17T15:40:21.000Z","updatedAt":"2020-08-17T15:40:21.000Z","Jasas":[{"jasa_id":3,"sub_category_id":2,"jasa_name":"jasa name 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:24.000Z","updatedAt":"2020-08-17T15:44:24.000Z"},{"jasa_id":4,"sub_category_id":2,"jasa_name":"jasa name 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:29.000Z","updatedAt":"2020-08-17T15:44:29.000Z"}]},{"sub_category_id":4,"category_id":1,"sub_category_name":"sub category 3","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-3.png","createdAt":"2020-08-17T15:40:35.000Z","updatedAt":"2020-08-17T15:40:35.000Z","Jasas":[{"jasa_id":7,"sub_category_id":4,"jasa_name":"jasa name","jasa_desc":"test desc","jasa_price":10000,"createdAt":"2020-08-17T15:48:03.000Z","updatedAt":"2020-08-17T15:48:03.000Z"}]},{"sub_category_id":5,"category_id":1,"sub_category_name":"sub category 4","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-4.png","createdAt":"2020-08-17T15:40:40.000Z","updatedAt":"2020-08-17T15:40:40.000Z","Jasas":[{"jasa_id":8,"sub_category_id":5,"jasa_name":"name1","jasa_desc":"test desc","jasa_price":10008,"createdAt":"2020-08-17T15:48:29.000Z","updatedAt":"2020-08-17T15:48:29.000Z"},{"jasa_id":9,"sub_category_id":5,"jasa_name":"name2","jasa_desc":"test desc","jasa_price":10008,"createdAt":"2020-08-17T15:48:35.000Z","updatedAt":"2020-08-17T15:48:35.000Z"}]}]
         */

        private int category_id;
        private String category_name;
        private String category_desc;
        private String createdAt;
        private String updatedAt;
        private List<SubCategoriesBean> Sub_categories;

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

        public List<SubCategoriesBean> getSub_categories() {
            return Sub_categories;
        }

        public void setSub_categories(List<SubCategoriesBean> Sub_categories) {
            this.Sub_categories = Sub_categories;
        }

        public static class SubCategoriesBean {
            /**
             * sub_category_id : 1
             * category_id : 1
             * sub_category_name : sub category 1
             * sub_category_desc : test desc
             * img_url : https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png
             * createdAt : 2020-08-17T15:39:39.000Z
             * updatedAt : 2020-08-17T15:39:39.000Z
             * Jasas : [{"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z"},{"jasa_id":2,"sub_category_id":1,"jasa_name":"jasa test 2","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:08.000Z","updatedAt":"2020-08-17T15:44:08.000Z"}]
             */

            private int sub_category_id;
            private int category_id;
            private String sub_category_name;
            private String sub_category_desc;
            private String img_url;
            private String createdAt;
            private String updatedAt;
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

            public List<JasasBean> getJasas() {
                return Jasas;
            }

            public void setJasas(List<JasasBean> Jasas) {
                this.Jasas = Jasas;
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
}
