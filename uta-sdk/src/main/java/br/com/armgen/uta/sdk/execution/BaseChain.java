/**
 * 
 */
package br.com.armgen.uta.sdk.execution;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.armgen.commons.behavior.ComponentBehavior;
import br.com.armgen.uta.sdk.element.Page;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leonardo.silva
 *
 */
@Slf4j
@Getter
@RequiredArgsConstructor
public abstract class BaseChain extends ComponentBehavior implements Chain, Serializable {
	
	private final UUID chaindId = UUID.randomUUID();
	private AtomicInteger countSteps = new AtomicInteger(1);
	private final Map<String, Step> steps = new LinkedHashMap<String, Step>();
	private Step currentStep;
	
	/**
	 * Browser que o passo será executado
	 */
	private @NonNull Browser browser;
	
	/**
	 * Define o browser para a execução do passo.
	 * @param browser Browser
	 * @return Instancia
	 */
//	public Chain browser(Browser browser) {
//		this.browser = browser;
//		return this;
//	}

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
		return this.browser.getCurrentPage();
	}

	@Override
	public void start() {
		this.browser.prepare();
		for (Entry<String, Step> entryStep : steps.entrySet()) {
			currentStep = entryStep.getValue();
			try {
				this.executePreBehaviors(this);
				this.executeStep(this, currentStep);
				this.executePostBehaviors(this);
			} catch (RuntimeException e) {
				log.error("Erro executando o step {}", currentStep , e);
				throw e;
			} catch (Exception e) {
				log.error("Erro executando o step {}", currentStep , e);
				throw e;
			}  
		}
	}

	/**
	 * 
	 * @param chain
	 * @param step
	 */
	protected abstract void executeStep(Chain chain, Step step);
	
	
	public Chain step(Step step) {
		this.steps.put(String.valueOf(countSteps.getAndIncrement()), step);
		return this;
	}

	@Override
	public void resetSteps(){
		this.steps.clear();
		this.countSteps = new AtomicInteger(1);
		this.currentStep = null;
	}

}
