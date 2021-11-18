package com.example.loan.bo;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BoTest {

    private String returnMessage;
    private boolean returnCode;

    public BoTest(String returnMessage, boolean returnCode) {
        this.returnMessage = returnMessage;
        this.returnCode = returnCode;
    }

    @Override
    public String toString() {
        return "{" +
                "\"returnCode\":\"" + returnCode + "\"," +
                "\"returnMessage\":" + (returnMessage == null ? "null" : "\"" + returnMessage + "\"") + "" +
                "}";
    }

    public String getReturnMessage() {

        return returnMessage;
    }

    public void setReturnMessage(String returnMessage)
    {
        this.returnMessage = returnMessage;
    }

    public boolean getReturnCode() {

        return returnCode;
    }

    public void setReturnCode(boolean returnCode)
    {
        this.returnCode = returnCode;
    }
}


