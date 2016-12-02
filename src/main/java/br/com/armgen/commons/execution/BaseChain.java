/**
 * 
 */
package br.com.armgen.commons.execution;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.armgen.commons.components.Parameters;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leonardo.silva
 *
 */
@Slf4j
public abstract class BaseChain implements Chain {
	
	private final UUID chaindId = UUID.randomUUID();
	private final AtomicInteger countSteps = new AtomicInteger(1);
	private final Map<String, Step> steps = new LinkedHashMap<String, Step>();
	private final Parameters parameters;
	
	public BaseChain(Parameters parameters) {
		super();
		this.parameters = parameters;
	}

	/**
	 * @return the steps
	 */
	protected Map<String, Step> getSteps() {
		return steps;
	}

	/**
	 * @return the parameters
	 */
	protected Parameters getParameters() {
		return parameters;
	}
	
	@Override
	public String getId() {
		return this.chaindId.toString();
	}
	
	@Override
	public void start() {
		final Context context = new Context(this, getParameters());
		for (Entry<String, Step> entryStep : steps.entrySet()) {
			Step step = entryStep.getValue();
			try {
				this.executeStep(step, context);
			} catch (RuntimeException e) {
				log.error("Erro executando o step {}", step , e);
			} catch (Exception e) {
				log.error("Erro executando o step {}", step , e);
			}  
		}
	}

	/**
	 * 
	 * @param step
	 */
	protected abstract void executeStep(Step step, Context context);
	
	
	public void addStep(Step step) {
		this.steps.put(String.valueOf(countSteps.getAndIncrement()), step);
	}

}
