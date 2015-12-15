package fr.iutvalence.info.dut.m3105.pattern.state;


public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalUserInterface
{
	private TrafficSignalState state;
	private Observator observator;

	public TrafficSignal(Observator observator)
	{
		super();
		this.observator = observator;
	}
	
	@Override
	public void setTrafficSignalState(TrafficSignalState state)
	{
		this.state = state;
		this.observator.notify("notify : " + state.getName().toString());
	}

	@Override
	public void pressButton()
	{
		this.state.buttonPressed();
	}
	
	public void run()
	{
		this.setTrafficSignalState(new TrafficSignalGreenState(this));
		while (true)
		{
			try
			{
				Thread.sleep(1000);
				this.state.secondEllapsed();
			}
			catch (InterruptedException e)
			{
				break;
			}
		}
	}
	
}
