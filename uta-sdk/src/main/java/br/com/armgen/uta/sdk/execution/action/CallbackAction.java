package br.com.armgen.uta.sdk.execution.action;

import br.com.armgen.uta.sdk.element.Page;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * Created by Pedro on 19/01/2017.
 */
@Data
public class CallbackAction implements Action {

    private @NonNull Callback callback;

    @Override
    public void execute(Page page) {
        this.callback.execute(page);
    }

    public interface Callback extends Serializable {

        public void execute(Page page);
    }
}
