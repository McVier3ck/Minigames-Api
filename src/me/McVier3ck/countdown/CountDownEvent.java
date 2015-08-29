package me.McVier3ck.countdown;

import javax.swing.event.EventListenerList;

public class CountDownEvent {

	protected EventListenerList listenerList = new EventListenerList();

	public void registeCountDownEvent(CountdownEventListener listener) {
		listenerList.add(CountdownEventListener.class, listener);
	}

	void CountDownFinish(CountdownFinishEvent event) {
		Object[] listeners = listenerList.getListenerList();
		for (int i = 0; i < listeners.length; i = i + 2) {
			if (listeners[i] == CountdownEventListener.class) {
				((CountdownEventListener) listeners[i + 1]).CountdownEventOccurred(event);
			}
		}
	}

}
