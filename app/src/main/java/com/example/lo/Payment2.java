package com.example.lo;

import android.os.Bundle;

import com.yenepaySDK.PaymentOrderManager;
import com.yenepaySDK.PaymentResponse;
import com.yenepaySDK.YenePayPaymentActivity;
import com.yenepaySDK.model.OrderedItem;

public class Payment2  extends YenePayPaymentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);
        checkout();
    }



    private void checkout(){

        PaymentOrderManager paymentMgr = new PaymentOrderManager(
                "2086",
                "1221291429");
        paymentMgr.setPaymentProcess(PaymentOrderManager.PROCESS_CART);

        paymentMgr.setReturnUrl("com.example.lo.yenepay:/payment2redirect");
        paymentMgr.setUseSandboxEnabled(true);
        paymentMgr.addItem(new OrderedItem("ITEM_ID", "Item Name", 2, 12.70));
        paymentMgr.startCheckout(this);
    }
    @Override
    public void onPaymentResponseArrived(PaymentResponse response) {
        //Handle Payment response
        if(response.isPaymentCompleted()){
            //Complete delivery
        }
    }

    @Override
    public void onPaymentResponseError(String error) {
        //Handle payment request error.
//        showMessage(error);//i commented my self uncommnet if any error happend
    }
}
