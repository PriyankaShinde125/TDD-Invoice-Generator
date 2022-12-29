package org.example;

import java.util.Objects;

public class Invoice {
    User user;
    InvoiceSummary invoiceSummary;

    public Invoice(User user, InvoiceSummary invoiceSummary) {
        this.user = user;
        this.invoiceSummary = invoiceSummary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(user, invoice.user);
    }

}
