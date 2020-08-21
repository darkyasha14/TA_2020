package com.example.ta_2020.order.model;

import java.util.List;

public class BookingList {

    /**
     * code : 0
     * message : successs get booking list by user ID
     * data : [{"invoice_no":"082016","user_id":2,"jasa_id":1,"payment_status":"UNPAID","createdAt":"2020-08-20T07:49:23.000Z","updatedAt":"2020-08-20T07:49:23.000Z","Jasa":{"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z","Sub_category":{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z"}},"User":{"user_id":2,"name":"irfan kurniawan","username":"irfankr14","password":"12345678","email":"harneti09@gmail.com","token_text":null,"is_login":true,"is_admin":false,"createdAt":"2020-08-15T18:04:47.000Z","updatedAt":"2020-08-15T18:09:45.000Z","Profil":{"profil_id":2,"user_id":2,"phone":null,"user_img":null,"createdAt":"2020-08-15T18:04:48.000Z","updatedAt":"2020-08-15T18:04:48.000Z"}}},{"invoice_no":"082027","user_id":2,"jasa_id":1,"payment_status":"UNPAID","createdAt":"2020-08-20T07:10:03.000Z","updatedAt":"2020-08-20T07:10:03.000Z","Jasa":{"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z","Sub_category":{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z"}},"User":{"user_id":2,"name":"irfan kurniawan","username":"irfankr14","password":"12345678","email":"harneti09@gmail.com","token_text":null,"is_login":true,"is_admin":false,"createdAt":"2020-08-15T18:04:47.000Z","updatedAt":"2020-08-15T18:09:45.000Z","Profil":{"profil_id":2,"user_id":2,"phone":null,"user_img":null,"createdAt":"2020-08-15T18:04:48.000Z","updatedAt":"2020-08-15T18:04:48.000Z"}}},{"invoice_no":"082093","user_id":2,"jasa_id":1,"payment_status":"UNPAID","createdAt":"2020-08-20T07:45:13.000Z","updatedAt":"2020-08-20T07:45:13.000Z","Jasa":{"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z","Sub_category":{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z"}},"User":{"user_id":2,"name":"irfan kurniawan","username":"irfankr14","password":"12345678","email":"harneti09@gmail.com","token_text":null,"is_login":true,"is_admin":false,"createdAt":"2020-08-15T18:04:47.000Z","updatedAt":"2020-08-15T18:09:45.000Z","Profil":{"profil_id":2,"user_id":2,"phone":null,"user_img":null,"createdAt":"2020-08-15T18:04:48.000Z","updatedAt":"2020-08-15T18:04:48.000Z"}}}]
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
         * invoice_no : 082016
         * user_id : 2
         * jasa_id : 1
         * payment_status : UNPAID
         * createdAt : 2020-08-20T07:49:23.000Z
         * updatedAt : 2020-08-20T07:49:23.000Z
         * Jasa : {"jasa_id":1,"sub_category_id":1,"jasa_name":"jasa test 1","jasa_desc":"test desc 123","jasa_price":10000,"createdAt":"2020-08-17T15:44:00.000Z","updatedAt":"2020-08-17T15:44:00.000Z","Sub_category":{"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z"}}
         * User : {"user_id":2,"name":"irfan kurniawan","username":"irfankr14","password":"12345678","email":"harneti09@gmail.com","token_text":null,"is_login":true,"is_admin":false,"createdAt":"2020-08-15T18:04:47.000Z","updatedAt":"2020-08-15T18:09:45.000Z","Profil":{"profil_id":2,"user_id":2,"phone":null,"user_img":null,"createdAt":"2020-08-15T18:04:48.000Z","updatedAt":"2020-08-15T18:04:48.000Z"}}
         */

        private String invoice_no;
        private int user_id;
        private int jasa_id;
        private String payment_status;
        private String createdAt;
        private String updatedAt;
        private JasaBean Jasa;
        private UserBean User;

        public String getInvoice_no() {
            return invoice_no;
        }

        public void setInvoice_no(String invoice_no) {
            this.invoice_no = invoice_no;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getJasa_id() {
            return jasa_id;
        }

        public void setJasa_id(int jasa_id) {
            this.jasa_id = jasa_id;
        }

        public String getPayment_status() {
            return payment_status;
        }

        public void setPayment_status(String payment_status) {
            this.payment_status = payment_status;
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

        public JasaBean getJasa() {
            return Jasa;
        }

        public void setJasa(JasaBean Jasa) {
            this.Jasa = Jasa;
        }

        public UserBean getUser() {
            return User;
        }

        public void setUser(UserBean User) {
            this.User = User;
        }

        public static class JasaBean {
            /**
             * jasa_id : 1
             * sub_category_id : 1
             * jasa_name : jasa test 1
             * jasa_desc : test desc 123
             * jasa_price : 10000
             * createdAt : 2020-08-17T15:44:00.000Z
             * updatedAt : 2020-08-17T15:44:00.000Z
             * Sub_category : {"sub_category_id":1,"category_id":1,"sub_category_name":"sub category 1","sub_category_desc":"test desc","img_url":"https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png","createdAt":"2020-08-17T15:39:39.000Z","updatedAt":"2020-08-17T15:39:39.000Z"}
             */

            private int jasa_id;
            private int sub_category_id;
            private String jasa_name;
            private String jasa_desc;
            private int jasa_price;
            private String createdAt;
            private String updatedAt;
            private SubCategoryBean Sub_category;

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

            public SubCategoryBean getSub_category() {
                return Sub_category;
            }

            public void setSub_category(SubCategoryBean Sub_category) {
                this.Sub_category = Sub_category;
            }

            public static class SubCategoryBean {
                /**
                 * sub_category_id : 1
                 * category_id : 1
                 * sub_category_name : sub category 1
                 * sub_category_desc : test desc
                 * img_url : https://darkyasha.goes2nobel.com/TA/back-end/./public/image/sub-category-1.png
                 * createdAt : 2020-08-17T15:39:39.000Z
                 * updatedAt : 2020-08-17T15:39:39.000Z
                 */

                private int sub_category_id;
                private int category_id;
                private String sub_category_name;
                private String sub_category_desc;
                private String img_url;
                private String createdAt;
                private String updatedAt;

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
            }
        }

        public static class UserBean {
            /**
             * user_id : 2
             * name : irfan kurniawan
             * username : irfankr14
             * password : 12345678
             * email : harneti09@gmail.com
             * token_text : null
             * is_login : true
             * is_admin : false
             * createdAt : 2020-08-15T18:04:47.000Z
             * updatedAt : 2020-08-15T18:09:45.000Z
             * Profil : {"profil_id":2,"user_id":2,"phone":null,"user_img":null,"createdAt":"2020-08-15T18:04:48.000Z","updatedAt":"2020-08-15T18:04:48.000Z"}
             */

            private int user_id;
            private String name;
            private String username;
            private String password;
            private String email;
            private Object token_text;
            private boolean is_login;
            private boolean is_admin;
            private String createdAt;
            private String updatedAt;
            private ProfilBean Profil;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Object getToken_text() {
                return token_text;
            }

            public void setToken_text(Object token_text) {
                this.token_text = token_text;
            }

            public boolean isIs_login() {
                return is_login;
            }

            public void setIs_login(boolean is_login) {
                this.is_login = is_login;
            }

            public boolean isIs_admin() {
                return is_admin;
            }

            public void setIs_admin(boolean is_admin) {
                this.is_admin = is_admin;
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

            public ProfilBean getProfil() {
                return Profil;
            }

            public void setProfil(ProfilBean Profil) {
                this.Profil = Profil;
            }

            public static class ProfilBean {
                /**
                 * profil_id : 2
                 * user_id : 2
                 * phone : null
                 * user_img : null
                 * createdAt : 2020-08-15T18:04:48.000Z
                 * updatedAt : 2020-08-15T18:04:48.000Z
                 */

                private int profil_id;
                private int user_id;
                private Object phone;
                private Object user_img;
                private String createdAt;
                private String updatedAt;

                public int getProfil_id() {
                    return profil_id;
                }

                public void setProfil_id(int profil_id) {
                    this.profil_id = profil_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public Object getPhone() {
                    return phone;
                }

                public void setPhone(Object phone) {
                    this.phone = phone;
                }

                public Object getUser_img() {
                    return user_img;
                }

                public void setUser_img(Object user_img) {
                    this.user_img = user_img;
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