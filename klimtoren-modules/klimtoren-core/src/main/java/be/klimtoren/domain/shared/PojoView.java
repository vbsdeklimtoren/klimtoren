package be.klimtoren.domain.shared;

import lombok.Data;

@Data
public class PojoView implements DataView {
	private final Object data;
	private final Class<? extends BaseView> view;
	
	@Override
	public boolean hasView() {
		return true;
	}


}