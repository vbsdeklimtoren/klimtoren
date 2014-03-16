package be.klimtoren.domain.shared;

public interface DataView {
	boolean hasView();
	Class<? extends BaseView> getView();
	Object getData();
}
