/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.armgen.commons.behavior.ComponentBehavior;
import br.com.armgen.uta.sdk.element.Page;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leonardo.silva
 *
 */
@Slf4j
public abstract class BaseChain extends ComponentBehavior implements Chain {
	
	private final UUID chaindId = UUID.randomUUID();
	private final AtomicInteger countSteps = new AtomicInteger(1);
	private final Map<String, Step> steps = new LinkedHashMap<String, Step>();
	private Step currentStep;
	
	/**
	 * Browser que o passo será executado
	 */
	private Browser browser;
	
	/**
	 * Define o browser para a execução do passo.
	 * @param browser Browser
	 * @return Instancia
	 */
	public Chain browser(Browser browser) {
		this.browser = browser;
		return this;
	}

	/**
	 * @return the steps
	 */
	protected Map<String, Step> getSteps() {
		return steps;
	}

	@Override
	public String getId() {
		return this.chaindId.toString();
	}
	
	@Override
	public Step getCurrentStep() {
		return this.currentStep;
	}
	
	@Override
	public Page getCurrentPage() {
		return this.browser.getPage();
	}

	@Override
	public void start() {
		final Context context = new Context(this);
		for (Entry<String, Step> entryStep : steps.entrySet()) {
			currentStep = entryStep.getValue();
			try {
				this.executePreBehaviors(this);
				this.executeStep(browser, currentStep, context);
				this.executePostBehaviors(this);
			} catch (RuntimeException e) {
				log.error("Erro executando o step {}", currentStep , e);
			} catch (Exception e) {
				log.error("Erro executando o step {}", currentStep , e);
			}  
		}
	}

	/**
	 * 
	 * @param browser 
	 * @param step
	 */
	protected abstract void executeStep(Browser browser, Step step, Context context);
	
	
	public void step(Step step) {
		this.steps.put(String.valueOf(countSteps.getAndIncrement()), step);
	}

}
