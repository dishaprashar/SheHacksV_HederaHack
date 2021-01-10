package hederahack.pages;

import java.io.IOException;

import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;
import org.rendersnake.RequestUtils;
import org.springframework.stereotype.Component;
import static org.rendersnake.HtmlAttributesFactory.*;

public class DonationResultPage implements Renderable {

    String userId;
    long amount;
    String charityId;
    long balance;

    public DonationResultPage(String userId, long amount, String charityId, long balance) {
        this.userId = userId;
        this.amount = amount;
        this.charityId = charityId;
        this.balance = balance;
    }

    @Override
    public void renderOn(HtmlCanvas html) throws IOException {
        html.h1()
                .write("Donation Result")
                ._h1();

        String msg = String.format("Thank you %s, we received your donation of %d for charity %s. Your balance is %d.",
                userId, amount, charityId, balance);


        html.div(class_("row")).p().content(msg)._div();

        html.div(class_("row"));
        html.a(class_("btn btn-primary").href("/donate")).content("Add Another Donation");
        html.a(class_("btn btn-secondary").href("/")).content("Logout");
        html._div();

    }
}