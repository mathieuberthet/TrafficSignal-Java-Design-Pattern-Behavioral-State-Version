 package fr.iutvalence.info.dut.m3105.pattern.state;

public class TrafficSignalRedState extends TrafficSignalState
{
	private final static int RED_STATE_DURATION_IN_SECONDS = 10;
	
	public TrafficSignalRedState(TrafficSignalContext context)
	{
		super(context, RED_STATE_DURATION_IN_SECONDS, TrafficSignalStateName.RED);
	}
 
	@Override
	public void secondEllapsed()
	{
		super.secondEllapsed();
		if (this.durationInSeconds == 0)
			this.context.setTrafficSignalState(new TrafficSignalGreenState(this.context));
	}
}
