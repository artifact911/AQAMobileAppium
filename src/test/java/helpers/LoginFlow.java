package helpers;

import lombok.experimental.UtilityClass;
import pages.change.password.ChangePasswordPage;
import pages.change.password.SuccessesPage;
import pages.confirmation.ConfirmationLoginPage;
import pages.login.LoginPage;
import pages.main.MainPage;
import pages.start.StartPage;
import util.WaitersUtil;

import static core.common.CommonConstants.CODE_AFTER_LOGIN;
import static core.common.CommonConstants.LOGIN;
import static core.common.CommonConstants.PASSWORD;

@UtilityClass
public class LoginFlow {

    public void logInFull() {
        StartPage startPage = new StartPage();
        WaitersUtil.waitForElementAndClick(startPage.getEnterBtnId(), "Enter button was not found");
        LoginPage loginPage = new LoginPage();
        WaitersUtil.waitForElementAndSendKeys(loginPage.getLoginField(), LOGIN, "Login field was not found");
        WaitersUtil.waitForElementAndSendKeys(loginPage.getPasswordField(), PASSWORD, "Password field was not found");
        WaitersUtil.waitForElPresent(loginPage.getEnterBTN(), "Enter button was not found").click();
        ConfirmationLoginPage confLoginPage = new ConfirmationLoginPage();
        WaitersUtil. waitForElementAndSendKeys(confLoginPage.getConfirmField(), CODE_AFTER_LOGIN, "Confirmation field was not found");
        WaitersUtil.waitForElPresent(confLoginPage.getConfirmBTN(), "Confirmation button was not found").click();
        ChangePasswordPage changePassPage = new ChangePasswordPage();
        WaitersUtil.waitForElementAndSendKeys(changePassPage.getCurrentPasswordField(), PASSWORD, "OldPassword field was not found");
        WaitersUtil.waitForElementAndSendKeys(changePassPage.getNewPasswordField(), "Arti911", "NewPassword field was not found");
        WaitersUtil.waitForElementAndSendKeys(changePassPage.getRepeatPasswordField(), "Arti911", "RepPassword field was not found");
        WaitersUtil.waitForElPresent(changePassPage.getSavePasswordBTN(), "SavePassBTN was not found").click();
        SuccessesPage successesPage = new SuccessesPage();
        WaitersUtil. waitForElPresent(successesPage.getToMainBTN(), "ToMain button was not found").click();
        MainPage mainPage = new MainPage();
        WaitersUtil.waitForElPresent(mainPage.getBarTitle(), "Title was not found");
    }
}
