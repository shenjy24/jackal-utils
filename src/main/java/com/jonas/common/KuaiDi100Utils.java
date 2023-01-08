package com.jonas.common;

import com.google.gson.Gson;
import com.kuaidi100.sdk.api.QueryTrack;
import com.kuaidi100.sdk.contant.CompanyConstant;
import com.kuaidi100.sdk.core.IBaseClient;
import com.kuaidi100.sdk.request.QueryTrackParam;
import com.kuaidi100.sdk.request.QueryTrackReq;
import com.kuaidi100.sdk.utils.SignUtils;

/**
 * 快递100工具类
 *
 * @author shenjy
 * @version 1.0
 * @date 2023-01-08
 */
public class KuaiDi100Utils {

    private static final String customer = "";
    private static final String key = "";

    /**
     * 实时快递查询接口
     *
     * @throws Exception
     */
    public static void queryTrack(String com, String num, String phone) throws Exception {

        QueryTrackReq queryTrackReq = new QueryTrackReq();
        QueryTrackParam queryTrackParam = new QueryTrackParam();
        queryTrackParam.setCom(com);
        queryTrackParam.setNum(num);
        queryTrackParam.setPhone(phone);
        String param = new Gson().toJson(queryTrackParam);

        queryTrackReq.setParam(param);
        queryTrackReq.setCustomer(customer);
        queryTrackReq.setSign(SignUtils.querySign(param, key, customer));

        IBaseClient baseClient = new QueryTrack();
        System.out.println(baseClient.execute(queryTrackReq));
    }

    public static void main(String[] args) {
        try {
            queryTrack(CompanyConstant.YT, "YT2237659878059", "17725390266");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
