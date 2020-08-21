package com.example.ta_2020.apihelper;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("auth")
    Call<ResponseBody> getLogin(@Field("username") String username,
                                @Field("password") String password);


    @FormUrlEncoded
    @POST("user")
    Call<ResponseBody> registerRequest(@Field("name") String name,
                                       @Field("username") String username,
                                       @Field("email") String email,
                                       @Field("password") String password);

    @FormUrlEncoded
    @PUT("user/{id}")
    Call<ResponseBody> updateUser(@Header("Authorization") String token,
                                  @Path("id") int id,
                                  @Field("name") String name,
                                  @Field("username") String username,
                                  @Field("password") String password,
                                  @Field("email") String email);

    @GET("profil/{id}")
    Call<ResponseBody> getUserData(@Header("Authorization") String token,
                                   @Path("id") int id);

    @Multipart
    @PUT("update-profil/{id}")
    Call<ResponseBody> updatePhone(@HeaderMap Map<String, String> stringStringMap,
                                   @PartMap Map<String, RequestBody> stringBody,
                                   @Part MultipartBody.Part filePart);

    @GET("category")
    Call<ResponseBody> getCategory(@Header("Authorization") String token);

    @GET("sub-category/{id}")
    Call<ResponseBody> getJasa(@Header("Authorization") String token,
                               @Path("id") int id);
    @FormUrlEncoded
    @POST("booking")
    Call<ResponseBody> makeOrder(@Header("Authorization") String token,
                                 @Field("user_id") int idUser,
                                 @Field("jasa_id") int idJasa);

    @GET("booking-list/{id}")
    Call<ResponseBody> getBookingList(@Header("Authorization") String token,
                                      @Path("id") int id);

    @GET("booking-detail/{invoice_no}")
    Call<ResponseBody> getBookingDetail(@Header("Authorization") String token,
                                        @Path("invoice_no") String id);

    @FormUrlEncoded
    @POST("payment")
    Call<ResponseBody> getPaymentMethod(@Header("Authorization") String token,
                                        @Field("user_id") int idUser,
                                        @Field("invoice_no") String id);

    @GET("transaction-complate-list/{id}")
    Call<ResponseBody> getTransactionComplateList(@Header("Authorization") String token,
                                                  @Path("id") int id);

    @GET("transaction-complate-detail/{invoice_no}")
    Call<ResponseBody> getTransactionComplateDetail(@Header("Authorization") String token,
                                                    @Path("invoice_no") String id);






}
