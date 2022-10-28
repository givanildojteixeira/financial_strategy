package front;

public class ContextOrder {
	
	private OrderState orderState;
	
	public ContextOrder(OrderState orderState) {
		this.orderState = orderState;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	
	public String doWork(Boolean ok){
		return orderState.doWork(ok);
	}

}
