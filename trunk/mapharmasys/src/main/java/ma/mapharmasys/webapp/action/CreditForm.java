package ma.mapharmasys.webapp.action;

import java.io.Serializable;

import ma.mapharmasys.model.Credit;
import ma.mapharmasys.service.CreditManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("creditForm")
@Scope("request")
public class CreditForm extends BasePage implements Serializable {
    private CreditManager creditManager;
    private Credit credit = new Credit();
    private Long id;

    @Autowired
    public void setCreditManager(@Qualifier("creditManager") CreditManager creditManager) {
        this.creditManager = creditManager;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String delete() {
        creditManager.remove(credit.getId());
        addMessage("credit.deleted");

        return "list";
    }

    public String edit() {
        // Workaround for not being able to set the id using #{param.id} when using Spring-configured managed-beans
        if (id == null) {
            id = new Long(getParameter("id"));
        }
        // Comparison to zero (vs. null) is required with MyFaces 1.2.2, not with previous versions
        if (id != null && id != 0) {
            credit = creditManager.get(id);
        } else {
            credit = new Credit();
        }

        return "edit";
    }

    public String save() {
        boolean isNew = (credit.getId() == null || credit.getId() == 0);
        creditManager.save(credit);

        String key = (isNew) ? "credit.added" : "credit.updated";
        addMessage(key);

        if (isNew) {
            return "list";
        } else {
            return "edit";
        }
    }
} 