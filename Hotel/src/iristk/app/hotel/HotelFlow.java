package iristk.app.hotel;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class HotelFlow extends iristk.flow.Flow {

	private iristk.situated.SystemAgentFlow agent;
	private Information info;
	private Weather weather;
	private Record call;
	private iristk.situated.SystemAgent system;
	private Integer number;
	private String lang;

	private void initVariables() {
		call = asRecord(new Record());
		system = (iristk.situated.SystemAgent) agent.getSystemAgent();
		lang = asString("en");
	}

	public Record getCall() {
		return this.call;
	}

	public void setCall(Record value) {
		this.call = value;
	}

	public iristk.situated.SystemAgent getSystem() {
		return this.system;
	}

	public void setSystem(iristk.situated.SystemAgent value) {
		this.system = value;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer value) {
		this.number = value;
	}

	public String getLang() {
		return this.lang;
	}

	public void setLang(String value) {
		this.lang = value;
	}

	public iristk.situated.SystemAgentFlow getAgent() {
		return this.agent;
	}

	public Information getInfo() {
		return this.info;
	}

	public Weather getWeather() {
		return this.weather;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("call")) return this.call;
		if (name.equals("system")) return this.system;
		if (name.equals("number")) return this.number;
		if (name.equals("lang")) return this.lang;
		if (name.equals("agent")) return this.agent;
		if (name.equals("info")) return this.info;
		if (name.equals("weather")) return this.weather;
		return null;
	}


	public HotelFlow(iristk.situated.SystemAgentFlow agent, Information info, Weather weather) {
		this.agent = agent;
		this.info = info;
		this.weather = weather;
		initVariables();
	}

	@Override
	public State getInitialState() {return new Idle();}


	public class Idle extends Dialog implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 23
			try {
				EXECUTION: {
					int count = getCount(295909702) + 1;
					incrCount(295909702);
					// Line: 24
					if (system.hasUsers()) {
						iristk.situated.SystemAgentFlow.attendRandom state0 = agent.new attendRandom();
						if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 24, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 26
						Greeting state1 = new Greeting();
						flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 26, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 27
					} else {
						iristk.situated.SystemAgentFlow.attendNobody state2 = agent.new attendNobody();
						if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 24, 33)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 23, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 31
			try {
				count = getCount(1508502878) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(1508502878);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attend state3 = agent.new attend();
						state3.setTarget(event.get("user"));
						if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 31, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 33
						Greeting state4 = new Greeting();
						flowThread.gotoState(state4, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 33, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 31, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Greeting extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 38
			try {
				EXECUTION: {
					int count = getCount(476275562) + 1;
					incrCount(476275562);
					// Line: 39
					Event sendEvent5 = new Event("action.voice");
					sendEvent5.putIfNotNull("name", "David");
					flowRunner.sendEvent(sendEvent5, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 39, 49)));
					iristk.situated.SystemAgentFlow.prompt state6 = agent.new prompt();
					StringCreator string7 = new StringCreator();
					string7.append("Hi there, Do you want me to speak English or Chinese?");
					state6.setText(string7.toString());
					if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 38, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 38, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 42
			try {
				count = getCount(1430165688) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:chinese")) {
						incrCount(1430165688);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 43
							lang = "zh";
							// Line: 44
							Event sendEvent8 = new Event("action.context.default");
							sendEvent8.putIfNotNull("context", "Chinese");
							flowRunner.sendEvent(sendEvent8, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 44, 66)));
							// Line: 45
							Event sendEvent9 = new Event("action.voice");
							sendEvent9.putIfNotNull("name", "HuiHui");
							flowRunner.sendEvent(sendEvent9, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 45, 52)));
							// Line: 46
							Start_CN state10 = new Start_CN();
							flowThread.gotoState(state10, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 46, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 42, 62));
			}
			// Line: 48
			try {
				count = getCount(2000756916) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:english")) {
						incrCount(2000756916);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 49
							lang = "en";
							// Line: 50
							Event sendEvent11 = new Event("action.context.default");
							sendEvent11.putIfNotNull("context", "English");
							flowRunner.sendEvent(sendEvent11, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 50, 65)));
							// Line: 51
							Event sendEvent12 = new Event("action.voice");
							sendEvent12.putIfNotNull("name", "David");
							flowRunner.sendEvent(sendEvent12, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 51, 51)));
							// Line: 52
							Start state13 = new Start();
							flowThread.gotoState(state13, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 52, 26)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 48, 62));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Start extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 57
			try {
				EXECUTION: {
					int count = getCount(104321852) + 1;
					incrCount(104321852);
					iristk.situated.SystemAgentFlow.prompt state14 = agent.new prompt();
					StringCreator string15 = new StringCreator();
					string15.append("What can I do for you?");
					state14.setText(string15.toString());
					if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 57, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 57, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 65
			try {
				count = getCount(1526028941) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(1526028941);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 67
							if (event.has("sem:natural")) {
								// Line: 68
								Nature state16 = new Nature();
								flowThread.gotoState(state16, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 68, 29)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 69
							} else if (event.has("sem:historical")) {
								// Line: 70
								History state17 = new History();
								flowThread.gotoState(state17, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 70, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 71
							} else if (event.has("sem:popular")) {
								// Line: 72
								Popular state18 = new Popular();
								flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 72, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 73
							} else {
								// Line: 74
								QueryAttr state19 = new QueryAttr();
								flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 74, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 65, 68));
			}
			// Line: 78
			try {
				count = getCount(1646631995) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(1646631995);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 79
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state20 = agent.new say();
								state20.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state20, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 79, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 81
								CheckAgain state21 = new CheckAgain();
								flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 81, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 82
							} else {
								// Line: 83
								QueryTrans state22 = new QueryTrans();
								flowThread.gotoState(state22, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 83, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 78, 71));
			}
			// Line: 87
			try {
				count = getCount(150857724) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(150857724);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 89
							QueryRoom state23 = new QueryRoom();
							flowThread.gotoState(state23, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 89, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 87, 62));
			}
			// Line: 92
			try {
				count = getCount(1640687744) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(1640687744);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 93
							QueryWeather state24 = new QueryWeather();
							flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 93, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 92, 62));
			}
			// Line: 96
			try {
				count = getCount(360512517) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(360512517);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 97
							MorningCall state25 = new MorningCall();
							flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 97, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 96, 59));
			}
			// Line: 100
			try {
				count = getCount(1594424290) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(1594424290);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state26 = agent.new say();
							StringCreator string27 = new StringCreator();
							string27.append("Okay");
							state26.setText(string27.toString());
							if (!flowThread.callState(state26, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 100, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 102
							Goodbye state28 = new Goodbye();
							flowThread.gotoState(state28, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 102, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 100, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Goodbye extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 110
			try {
				EXECUTION: {
					int count = getCount(2069960953) + 1;
					incrCount(2069960953);
					iristk.situated.SystemAgentFlow.say state29 = agent.new say();
					StringCreator string30 = new StringCreator();
					string30.append("Goodbye.");
					state29.setText(string30.toString());
					if (!flowThread.callState(state29, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 110, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state31 = agent.new say();
					StringCreator string32 = new StringCreator();
					string32.append("Please leave the detection area");
					state31.setText(string32.toString());
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 110, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 113
					iristk.flow.DialogFlow.wait waitState33 = new iristk.flow.DialogFlow.wait();
					waitState33.setMsec(2000);
					if (!flowThread.callState(waitState33, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 113, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 114
					Idle state34 = new Idle();
					flowThread.gotoState(state34, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 114, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 110, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryAttr extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 121
			try {
				EXECUTION: {
					int count = getCount(272046724) + 1;
					incrCount(272046724);
					iristk.situated.SystemAgentFlow.prompt state35 = agent.new prompt();
					StringCreator string36 = new StringCreator();
					string36.append("What kind of tourist attractions do you want to visit? Natural, historical or popular?");
					state35.setText(string36.toString());
					if (!flowThread.callState(state35, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 121, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 121, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 126
			try {
				count = getCount(47657413) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(47657413);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 127
							Nature state37 = new Nature();
							flowThread.gotoState(state37, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 127, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 126, 68));
			}
			// Line: 129
			try {
				count = getCount(716699795) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(716699795);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 130
							History state38 = new History();
							flowThread.gotoState(state38, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 130, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 129, 71));
			}
			// Line: 132
			try {
				count = getCount(958297336) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(958297336);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 133
							Popular state39 = new Popular();
							flowThread.gotoState(state39, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 133, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 132, 66));
			}
			// Line: 135
			try {
				count = getCount(1835116745) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1835116745);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 136
							CheckAgain state40 = new CheckAgain();
							flowThread.gotoState(state40, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 136, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 135, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Nature extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 141
			try {
				EXECUTION: {
					int count = getCount(30261310) + 1;
					incrCount(30261310);
					iristk.situated.SystemAgentFlow.say state41 = agent.new say();
					state41.setText(info.recommend(info.readattr(),"Natural"));
					if (!flowThread.callState(state41, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 141, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 143
					Attrdetial state42 = new Attrdetial();
					flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 143, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 141, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class History extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 148
			try {
				EXECUTION: {
					int count = getCount(869251148) + 1;
					incrCount(869251148);
					iristk.situated.SystemAgentFlow.say state43 = agent.new say();
					state43.setText(info.recommend(info.readattr(),"Historical"));
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 148, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 150
					Attrdetial state44 = new Attrdetial();
					flowThread.gotoState(state44, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 150, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 148, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Popular extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 155
			try {
				EXECUTION: {
					int count = getCount(2101843478) + 1;
					incrCount(2101843478);
					iristk.situated.SystemAgentFlow.say state45 = agent.new say();
					state45.setText(info.popular(info.readattr()));
					if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 155, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 157
					Attrdetial state46 = new Attrdetial();
					flowThread.gotoState(state46, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 157, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 155, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Attrdetial extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 162
			try {
				EXECUTION: {
					int count = getCount(350210137) + 1;
					incrCount(350210137);
					iristk.situated.SystemAgentFlow.prompt state47 = agent.new prompt();
					StringCreator string48 = new StringCreator();
					string48.append("If you want more details for attractions,please say the name.");
					state47.setText(string48.toString());
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 162, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 162, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 165
			try {
				count = getCount(1441336306) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1441336306);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 166
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state49 = agent.new say();
							state49.setText(info.detail(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 165, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 168
							CheckAgain state50 = new CheckAgain();
							flowThread.gotoState(state50, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 168, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 165, 69));
			}
			// Line: 170
			try {
				count = getCount(519224893) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(519224893);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 171
							CheckAgain state51 = new CheckAgain();
							flowThread.gotoState(state51, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 171, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 170, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryTrans extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 177
			try {
				EXECUTION: {
					int count = getCount(1973128404) + 1;
					incrCount(1973128404);
					iristk.situated.SystemAgentFlow.prompt state52 = agent.new prompt();
					StringCreator string53 = new StringCreator();
					string53.append("Where do you want to go?");
					state52.setText(string53.toString());
					if (!flowThread.callState(state52, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 177, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 177, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 180
			try {
				count = getCount(2115229452) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(2115229452);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state54 = agent.new say();
							state54.setText(event.get("sem:attrname"));
							if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 180, 65)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state55 = agent.new say();
							state55.setText(info.transdetail(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state55, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 180, 65)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 183
							CheckAgain state56 = new CheckAgain();
							flowThread.gotoState(state56, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 183, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 180, 65));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryRoom extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 189
			try {
				EXECUTION: {
					int count = getCount(1472691720) + 1;
					incrCount(1472691720);
					iristk.situated.SystemAgentFlow.prompt state57 = agent.new prompt();
					StringCreator string58 = new StringCreator();
					string58.append("Which room do you want to find?");
					state57.setText(string58.toString());
					if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 189, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 189, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 192
			try {
				count = getCount(923564107) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(923564107);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state59 = agent.new say();
							StringCreator string60 = new StringCreator();
							string60.append("It is on the first floor");
							state59.setText(string60.toString());
							if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 192, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 194
							CheckAgain state61 = new CheckAgain();
							flowThread.gotoState(state61, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 194, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 192, 70));
			}
			// Line: 196
			try {
				count = getCount(1810826586) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1810826586);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 197
						String ss = event.get("text").toString();
						// Line: 198
						if (eq("Sorry",info.findroom(ss))) {
							iristk.situated.SystemAgentFlow.say state62 = agent.new say();
							StringCreator string63 = new StringCreator();
							string63.append("Sorry, I didn't get that.");
							state62.setText(string63.toString());
							if (!flowThread.callState(state62, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 198, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 200
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 200, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 201
						} else {
							iristk.situated.SystemAgentFlow.say state64 = agent.new say();
							state64.setText(info.findroom(ss));
							if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 198, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 203
							CheckAgain state65 = new CheckAgain();
							flowThread.gotoState(state65, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 203, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 196, 42));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryWeather extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 210
			try {
				EXECUTION: {
					int count = getCount(1769402147) + 1;
					incrCount(1769402147);
					iristk.situated.SystemAgentFlow.say state66 = agent.new say();
					state66.setText(weather.getweather());
					if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 210, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 212
					CheckAgain state67 = new CheckAgain();
					flowThread.gotoState(state67, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 212, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 210, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class MorningCall extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 218
			try {
				EXECUTION: {
					int count = getCount(193584679) + 1;
					incrCount(193584679);
					// Line: 219
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					// Line: 220
					checkcall state68 = new checkcall();
					flowThread.gotoState(state68, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 220, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 218, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class checkcall extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 225
			try {
				EXECUTION: {
					int count = getCount(1994262219) + 1;
					incrCount(1994262219);
					// Line: 226
					if (!call.has("hour")) {
						// Line: 227
						askhour state69 = new askhour();
						flowThread.gotoState(state69, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 227, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 228
					} else if (!call.has("minute")) {
						// Line: 229
						askminute state70 = new askminute();
						flowThread.gotoState(state70, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 229, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 230
					} else if (!call.has("apm")) {
						// Line: 231
						askapm state71 = new askapm();
						flowThread.gotoState(state71, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 231, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 232
					} else if (!call.has("date")) {
						// Line: 233
						askdate state72 = new askdate();
						flowThread.gotoState(state72, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 233, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 234
					} else {
						// Line: 235
						calldone state73 = new calldone();
						flowThread.gotoState(state73, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 235, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 225, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askhour extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 241
			try {
				EXECUTION: {
					int count = getCount(530952599) + 1;
					incrCount(530952599);
					iristk.situated.SystemAgentFlow.prompt state74 = agent.new prompt();
					StringCreator string75 = new StringCreator();
					string75.append("Please say the hour of the morning call.");
					state74.setText(string75.toString());
					if (!flowThread.callState(state74, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 241, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 241, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 244
			try {
				count = getCount(918394376) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(918394376);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 245
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 246
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state76 = agent.new say();
								StringCreator string77 = new StringCreator();
								string77.append("Sorry the time is invalid.");
								state76.setText(string77.toString());
								if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 246, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 248
							} else if ( num > 11 ) {
								// Line: 249
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 250
							} else {
								// Line: 251
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 253
							checkcall state78 = new checkcall();
							flowThread.gotoState(state78, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 253, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 244, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askminute extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 258
			try {
				EXECUTION: {
					int count = getCount(1331534815) + 1;
					incrCount(1331534815);
					iristk.situated.SystemAgentFlow.prompt state79 = agent.new prompt();
					StringCreator string80 = new StringCreator();
					string80.append("Please say the minute of the morning call.");
					state79.setText(string80.toString());
					if (!flowThread.callState(state79, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 258, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 258, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 261
			try {
				count = getCount(971467013) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(971467013);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 262
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 263
							checkcall state81 = new checkcall();
							flowThread.gotoState(state81, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 263, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 261, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askapm extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 268
			try {
				EXECUTION: {
					int count = getCount(1176421430) + 1;
					incrCount(1176421430);
					iristk.situated.SystemAgentFlow.prompt state82 = agent.new prompt();
					StringCreator string83 = new StringCreator();
					string83.append("Is it a.m. or p.m.?");
					state82.setText(string83.toString());
					if (!flowThread.callState(state82, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 268, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 268, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 271
			try {
				count = getCount(1374452531) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(1374452531);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 272
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 273
							checkcall state84 = new checkcall();
							flowThread.gotoState(state84, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 273, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 271, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askdate extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 278
			try {
				EXECUTION: {
					int count = getCount(1996632385) + 1;
					incrCount(1996632385);
					iristk.situated.SystemAgentFlow.prompt state85 = agent.new prompt();
					StringCreator string86 = new StringCreator();
					string86.append("Do we need to call you at today or tomorrow?");
					state85.setText(string86.toString());
					if (!flowThread.callState(state85, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 278, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 278, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 281
			try {
				count = getCount(1133037778) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(1133037778);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 282
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 283
							checkcall state87 = new checkcall();
							flowThread.gotoState(state87, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 283, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 281, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class calldone extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 288
			try {
				EXECUTION: {
					int count = getCount(1783073484) + 1;
					incrCount(1783073484);
					// Line: 289
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state88 = agent.new prompt();
					state88.setText(info.timeconfirm(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state88, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 288, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 288, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 293
			try {
				count = getCount(876018403) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(876018403);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 294
							callroom state89 = new callroom();
							flowThread.gotoState(state89, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 294, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 293, 58));
			}
			// Line: 296
			try {
				count = getCount(1837082682) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1837082682);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 297
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 298
							MorningCall state90 = new MorningCall();
							flowThread.gotoState(state90, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 298, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 296, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class callroom extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 303
			try {
				EXECUTION: {
					int count = getCount(316328577) + 1;
					incrCount(316328577);
					iristk.situated.SystemAgentFlow.prompt state91 = agent.new prompt();
					StringCreator string92 = new StringCreator();
					string92.append("Which room do you live in?");
					state91.setText(string92.toString());
					if (!flowThread.callState(state91, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 303, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 303, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 306
			try {
				count = getCount(1311923437) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1311923437);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 307
						String sss = event.get("text").toString();
						// Line: 308
						if (eq("Sorry",info.callroom(sss))) {
							iristk.situated.SystemAgentFlow.say state93 = agent.new say();
							StringCreator string94 = new StringCreator();
							string94.append("Sorry, I didn't get that.");
							state93.setText(string94.toString());
							if (!flowThread.callState(state93, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 308, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 310
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 310, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 311
						} else {
							iristk.situated.SystemAgentFlow.say state95 = agent.new say();
							state95.setText(info.callroom(sss));
							if (!flowThread.callState(state95, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 308, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 313
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 314
							roomconfirm state96 = new roomconfirm();
							flowThread.gotoState(state96, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 314, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 306, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class roomconfirm extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 320
			try {
				EXECUTION: {
					int count = getCount(961083337) + 1;
					incrCount(961083337);
					iristk.situated.SystemAgentFlow.listen state97 = agent.new listen();
					if (!flowThread.callState(state97, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 320, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 320, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 323
			try {
				count = getCount(1786560781) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1786560781);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 324
							call.remove("room");
							// Line: 325
							callroom state98 = new callroom();
							flowThread.gotoState(state98, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 325, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 323, 57));
			}
			// Line: 327
			try {
				count = getCount(1249020286) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1249020286);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 328
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 331
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 332
							CheckAgain state99 = new CheckAgain();
							flowThread.gotoState(state99, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 332, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 327, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 340
			try {
				EXECUTION: {
					int count = getCount(1064077240) + 1;
					incrCount(1064077240);
					iristk.situated.SystemAgentFlow.prompt state100 = agent.new prompt();
					StringCreator string101 = new StringCreator();
					string101.append("Do you need other help?");
					state100.setText(string101.toString());
					if (!flowThread.callState(state100, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 340, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 340, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 343
			try {
				count = getCount(53073009) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(53073009);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state102 = agent.new say();
							StringCreator string103 = new StringCreator();
							string103.append("Okay");
							state102.setText(string103.toString());
							if (!flowThread.callState(state102, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 343, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 345
							Start state104 = new Start();
							flowThread.gotoState(state104, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 345, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 343, 58));
			}
			// Line: 347
			try {
				count = getCount(1742724904) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1742724904);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state105 = agent.new say();
							StringCreator string106 = new StringCreator();
							string106.append("Okay");
							state105.setText(string106.toString());
							if (!flowThread.callState(state105, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 347, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 349
							Goodbye state107 = new Goodbye();
							flowThread.gotoState(state107, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 349, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 347, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 354
			try {
				count = getCount(1441863674) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1441863674);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state108 = agent.new gesture();
							state108.setName("smile");
							if (!flowThread.callState(state108, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 354, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 354, 102));
			}
			// Line: 357
			try {
				count = getCount(1280222451) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1280222451);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state109 = agent.new say();
						StringCreator string110 = new StringCreator();
						string110.append("Sorry, I didn't get that.");
						state109.setText(string110.toString());
						if (!flowThread.callState(state109, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 357, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 359
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 359, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 357, 36));
			}
			// Line: 361
			try {
				count = getCount(1073190368) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1073190368);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state111 = agent.new attendOther();
						state111.setMode("eyes");
						if (!flowThread.callState(state111, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 361, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state112 = agent.new say();
						StringCreator string113 = new StringCreator();
						string113.append("I didn't ask you.");
						state112.setText(string113.toString());
						if (!flowThread.callState(state112, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 361, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state114 = agent.new attendOther();
						state114.setMode("eyes");
						if (!flowThread.callState(state114, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 361, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 365
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 365, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 361, 41));
			}
			// Line: 367
			try {
				count = getCount(1538544288) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1538544288);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state115 = agent.new say();
						StringCreator string116 = new StringCreator();
						string116.append("Don't speak at the same time.");
						state115.setText(string116.toString());
						if (!flowThread.callState(state115, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 367, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 369
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 369, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 367, 42));
			}
			// Line: 371
			try {
				count = getCount(87392097) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(87392097);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state117 = agent.new say();
						StringCreator string118 = new StringCreator();
						string118.append("Sorry, I didn't hear anything.");
						state117.setText(string118.toString());
						if (!flowThread.callState(state117, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 371, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 373
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 373, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 371, 38));
			}
			// Line: 375
			try {
				count = getCount(1041378028) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1041378028);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state119 = agent.new say();
							StringCreator string120 = new StringCreator();
							string120.append("Goodbye");
							state119.setText(string120.toString());
							if (!flowThread.callState(state119, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 375, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 381
							Idle state121 = new Idle();
							flowThread.gotoState(state121, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 381, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 375, 69));
			}
			// Line: 384
			try {
				count = getCount(1677270824) + 1;
				if (event.triggers("repeat")) {
					incrCount(1677270824);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 385
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 385, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 384, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Start_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 397
			try {
				EXECUTION: {
					int count = getCount(1504057176) + 1;
					incrCount(1504057176);
					iristk.situated.SystemAgentFlow.prompt state122 = agent.new prompt();
					StringCreator string123 = new StringCreator();
					string123.append("请问有什么可以帮到您的？");
					state122.setText(string123.toString());
					if (!flowThread.callState(state122, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 397, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 397, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 405
			try {
				count = getCount(1921864475) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(1921864475);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 407
							if (event.has("sem:natural")) {
								// Line: 408
								Nature_CN state124 = new Nature_CN();
								flowThread.gotoState(state124, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 408, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 409
							} else if (event.has("sem:historical")) {
								// Line: 410
								History_CN state125 = new History_CN();
								flowThread.gotoState(state125, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 410, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 411
							} else if (event.has("sem:popular")) {
								// Line: 412
								Popular_CN state126 = new Popular_CN();
								flowThread.gotoState(state126, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 412, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 413
							} else {
								// Line: 414
								QueryAttr_CN state127 = new QueryAttr_CN();
								flowThread.gotoState(state127, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 414, 35)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 405, 68));
			}
			// Line: 418
			try {
				count = getCount(1548549423) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(1548549423);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 419
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state128 = agent.new say();
								state128.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state128, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 419, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 421
								CheckAgain_CN state129 = new CheckAgain_CN();
								flowThread.gotoState(state129, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 421, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 422
							} else {
								// Line: 423
								QueryTrans_CN state130 = new QueryTrans_CN();
								flowThread.gotoState(state130, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 423, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 418, 71));
			}
			// Line: 427
			try {
				count = getCount(1841914008) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(1841914008);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 428
							QueryRoom_CN state131 = new QueryRoom_CN();
							flowThread.gotoState(state131, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 428, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 427, 62));
			}
			// Line: 431
			try {
				count = getCount(1462433556) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(1462433556);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 432
							QueryWeather_CN state132 = new QueryWeather_CN();
							flowThread.gotoState(state132, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 432, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 431, 62));
			}
			// Line: 435
			try {
				count = getCount(1536032908) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(1536032908);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 436
							MorningCall_CN state133 = new MorningCall_CN();
							flowThread.gotoState(state133, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 436, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 435, 59));
			}
			// Line: 439
			try {
				count = getCount(441458914) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(441458914);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state134 = agent.new say();
							StringCreator string135 = new StringCreator();
							string135.append("好的");
							state134.setText(string135.toString());
							if (!flowThread.callState(state134, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 439, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 441
							Goodbye_CN state136 = new Goodbye_CN();
							flowThread.gotoState(state136, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 441, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 439, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Goodbye_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 448
			try {
				EXECUTION: {
					int count = getCount(1781190877) + 1;
					incrCount(1781190877);
					iristk.situated.SystemAgentFlow.say state137 = agent.new say();
					StringCreator string138 = new StringCreator();
					string138.append("再见。");
					state137.setText(string138.toString());
					if (!flowThread.callState(state137, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 448, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state139 = agent.new say();
					StringCreator string140 = new StringCreator();
					string140.append("请离开感应区域");
					state139.setText(string140.toString());
					if (!flowThread.callState(state139, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 448, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 451
					iristk.flow.DialogFlow.wait waitState141 = new iristk.flow.DialogFlow.wait();
					waitState141.setMsec(2000);
					if (!flowThread.callState(waitState141, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 451, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 452
					Idle state142 = new Idle();
					flowThread.gotoState(state142, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 452, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 448, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryAttr_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 459
			try {
				EXECUTION: {
					int count = getCount(756561148) + 1;
					incrCount(756561148);
					iristk.situated.SystemAgentFlow.prompt state143 = agent.new prompt();
					StringCreator string144 = new StringCreator();
					string144.append("您想参观哪种景点？自然景点，历史景点还是热门景点？");
					state143.setText(string144.toString());
					if (!flowThread.callState(state143, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 459, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 459, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 464
			try {
				count = getCount(533743836) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(533743836);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 465
							Nature_CN state145 = new Nature_CN();
							flowThread.gotoState(state145, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 465, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 464, 68));
			}
			// Line: 467
			try {
				count = getCount(663385756) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(663385756);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 468
							History_CN state146 = new History_CN();
							flowThread.gotoState(state146, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 468, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 467, 71));
			}
			// Line: 470
			try {
				count = getCount(1456619082) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(1456619082);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 471
							Popular_CN state147 = new Popular_CN();
							flowThread.gotoState(state147, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 471, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 470, 66));
			}
			// Line: 473
			try {
				count = getCount(824512800) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(824512800);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 474
							CheckAgain_CN state148 = new CheckAgain_CN();
							flowThread.gotoState(state148, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 474, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 473, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Nature_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 479
			try {
				EXECUTION: {
					int count = getCount(1292470710) + 1;
					incrCount(1292470710);
					iristk.situated.SystemAgentFlow.say state149 = agent.new say();
					state149.setText(info.recommend_CN(info.readattr(),"Natural"));
					if (!flowThread.callState(state149, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 479, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 481
					Attrdetial_CN state150 = new Attrdetial_CN();
					flowThread.gotoState(state150, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 481, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 479, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class History_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 486
			try {
				EXECUTION: {
					int count = getCount(702890604) + 1;
					incrCount(702890604);
					iristk.situated.SystemAgentFlow.say state151 = agent.new say();
					state151.setText(info.recommend_CN(info.readattr(),"Historical"));
					if (!flowThread.callState(state151, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 486, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 488
					Attrdetial_CN state152 = new Attrdetial_CN();
					flowThread.gotoState(state152, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 488, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 486, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Popular_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 493
			try {
				EXECUTION: {
					int count = getCount(513380880) + 1;
					incrCount(513380880);
					iristk.situated.SystemAgentFlow.say state153 = agent.new say();
					state153.setText(info.popular_CN(info.readattr()));
					if (!flowThread.callState(state153, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 493, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 495
					Attrdetial_CN state154 = new Attrdetial_CN();
					flowThread.gotoState(state154, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 495, 37)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 493, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Attrdetial_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 500
			try {
				EXECUTION: {
					int count = getCount(718437420) + 1;
					incrCount(718437420);
					iristk.situated.SystemAgentFlow.prompt state155 = agent.new prompt();
					StringCreator string156 = new StringCreator();
					string156.append("如果您想了解某个景点的详情，请说出该景点的名字。");
					state155.setText(string156.toString());
					if (!flowThread.callState(state155, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 500, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 500, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 503
			try {
				count = getCount(2013880948) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(2013880948);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 504
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state157 = agent.new say();
							state157.setText(info.detail_CN(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state157, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 503, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 506
							CheckAgain_CN state158 = new CheckAgain_CN();
							flowThread.gotoState(state158, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 506, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 503, 69));
			}
			// Line: 508
			try {
				count = getCount(364216995) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(364216995);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 509
							CheckAgain_CN state159 = new CheckAgain_CN();
							flowThread.gotoState(state159, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 509, 39)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 508, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryTrans_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 515
			try {
				EXECUTION: {
					int count = getCount(1152491826) + 1;
					incrCount(1152491826);
					iristk.situated.SystemAgentFlow.prompt state160 = agent.new prompt();
					StringCreator string161 = new StringCreator();
					string161.append("您打算去哪里？");
					state160.setText(string161.toString());
					if (!flowThread.callState(state160, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 515, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 515, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 518
			try {
				count = getCount(2099811229) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:attrname")) {
						incrCount(2099811229);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state162 = agent.new say();
							state162.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state162, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 518, 63)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 520
							CheckAgain_CN state163 = new CheckAgain_CN();
							flowThread.gotoState(state163, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 520, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 518, 63));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryRoom_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 526
			try {
				EXECUTION: {
					int count = getCount(462718595) + 1;
					incrCount(462718595);
					iristk.situated.SystemAgentFlow.prompt state164 = agent.new prompt();
					StringCreator string165 = new StringCreator();
					string165.append("您在找哪个房间？");
					state164.setText(string165.toString());
					if (!flowThread.callState(state164, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 526, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 526, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 529
			try {
				count = getCount(572082711) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(572082711);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state166 = agent.new say();
							StringCreator string167 = new StringCreator();
							string167.append("它在一楼。");
							state166.setText(string167.toString());
							if (!flowThread.callState(state166, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 529, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 531
							CheckAgain_CN state168 = new CheckAgain_CN();
							flowThread.gotoState(state168, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 531, 37)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 529, 70));
			}
			// Line: 533
			try {
				count = getCount(1302732953) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(1302732953);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 534
						String ss = event.get("text").toString();
						// Line: 535
						if (eq("Sorry",info.findroom_CN(ss))) {
							iristk.situated.SystemAgentFlow.say state169 = agent.new say();
							StringCreator string170 = new StringCreator();
							string170.append("抱歉，我没有理解您说的话。");
							state169.setText(string170.toString());
							if (!flowThread.callState(state169, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 535, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 537
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 537, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 538
						} else {
							iristk.situated.SystemAgentFlow.say state171 = agent.new say();
							state171.setText(info.findroom_CN(ss));
							if (!flowThread.callState(state171, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 535, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 540
							CheckAgain_CN state172 = new CheckAgain_CN();
							flowThread.gotoState(state172, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 540, 38)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 533, 42));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class QueryWeather_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 547
			try {
				EXECUTION: {
					int count = getCount(712052019) + 1;
					incrCount(712052019);
					iristk.situated.SystemAgentFlow.say state173 = agent.new say();
					state173.setText(weather.getweather_CN());
					if (!flowThread.callState(state173, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 547, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 549
					CheckAgain_CN state174 = new CheckAgain_CN();
					flowThread.gotoState(state174, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 549, 33)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 547, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class MorningCall_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 554
			try {
				EXECUTION: {
					int count = getCount(1087400857) + 1;
					incrCount(1087400857);
					// Line: 555
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					// Line: 556
					checkcall_CN state175 = new checkcall_CN();
					flowThread.gotoState(state175, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 556, 32)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 554, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class checkcall_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 561
			try {
				EXECUTION: {
					int count = getCount(1899227379) + 1;
					incrCount(1899227379);
					// Line: 562
					if (!call.has("hour")) {
						// Line: 563
						askhour_CN state176 = new askhour_CN();
						flowThread.gotoState(state176, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 563, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 564
					} else if (!call.has("minute")) {
						// Line: 565
						askminute_CN state177 = new askminute_CN();
						flowThread.gotoState(state177, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 565, 33)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 566
					} else if (!call.has("apm")) {
						// Line: 567
						askapm_CN state178 = new askapm_CN();
						flowThread.gotoState(state178, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 567, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 568
					} else if (!call.has("date")) {
						// Line: 569
						askdate_CN state179 = new askdate_CN();
						flowThread.gotoState(state179, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 569, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 570
					} else {
						// Line: 571
						calldone_CN state180 = new calldone_CN();
						flowThread.gotoState(state180, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 571, 32)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 561, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askhour_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 577
			try {
				EXECUTION: {
					int count = getCount(862274078) + 1;
					incrCount(862274078);
					iristk.situated.SystemAgentFlow.prompt state181 = agent.new prompt();
					StringCreator string182 = new StringCreator();
					string182.append("请设置小时数。");
					state181.setText(string182.toString());
					if (!flowThread.callState(state181, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 577, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 577, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 580
			try {
				count = getCount(335771050) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(335771050);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 581
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 582
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state183 = agent.new say();
								StringCreator string184 = new StringCreator();
								string184.append("对不起这是无效的时间。");
								state183.setText(string184.toString());
								if (!flowThread.callState(state183, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 582, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 584
							} else if ( num > 11 ) {
								// Line: 585
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 586
							} else {
								// Line: 587
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 589
							checkcall_CN state185 = new checkcall_CN();
							flowThread.gotoState(state185, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 589, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 580, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askminute_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 594
			try {
				EXECUTION: {
					int count = getCount(1843501627) + 1;
					incrCount(1843501627);
					iristk.situated.SystemAgentFlow.prompt state186 = agent.new prompt();
					StringCreator string187 = new StringCreator();
					string187.append("请设置分钟数。");
					state186.setText(string187.toString());
					if (!flowThread.callState(state186, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 594, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 594, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 597
			try {
				count = getCount(98436734) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(98436734);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 598
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 599
							checkcall_CN state188 = new checkcall_CN();
							flowThread.gotoState(state188, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 599, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 597, 61));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askapm_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 604
			try {
				EXECUTION: {
					int count = getCount(2119230929) + 1;
					incrCount(2119230929);
					iristk.situated.SystemAgentFlow.prompt state189 = agent.new prompt();
					StringCreator string190 = new StringCreator();
					string190.append("请问是上午还是下午?");
					state189.setText(string190.toString());
					if (!flowThread.callState(state189, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 604, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 604, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 607
			try {
				count = getCount(1566913804) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(1566913804);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 608
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 609
							checkcall_CN state191 = new checkcall_CN();
							flowThread.gotoState(state191, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 609, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 607, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class askdate_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 614
			try {
				EXECUTION: {
					int count = getCount(974725787) + 1;
					incrCount(974725787);
					iristk.situated.SystemAgentFlow.prompt state192 = agent.new prompt();
					StringCreator string193 = new StringCreator();
					string193.append("请问是今天还是明天？");
					state192.setText(string193.toString());
					if (!flowThread.callState(state192, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 614, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 614, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 617
			try {
				count = getCount(374400773) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(374400773);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 618
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 619
							checkcall_CN state194 = new checkcall_CN();
							flowThread.gotoState(state194, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 619, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 617, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class calldone_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 624
			try {
				EXECUTION: {
					int count = getCount(901468191) + 1;
					incrCount(901468191);
					// Line: 625
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state195 = agent.new prompt();
					state195.setText(info.timeconfirm_CN(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state195, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 624, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 624, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 629
			try {
				count = getCount(1667115000) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1667115000);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 630
							callroom_CN state196 = new callroom_CN();
							flowThread.gotoState(state196, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 630, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 629, 58));
			}
			// Line: 632
			try {
				count = getCount(1071739380) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1071739380);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 633
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 634
							MorningCall_CN state197 = new MorningCall_CN();
							flowThread.gotoState(state197, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 634, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 632, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class callroom_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 639
			try {
				EXECUTION: {
					int count = getCount(799403214) + 1;
					incrCount(799403214);
					iristk.situated.SystemAgentFlow.prompt state198 = agent.new prompt();
					StringCreator string199 = new StringCreator();
					string199.append("请问您的房间号是多少？");
					state198.setText(string199.toString());
					if (!flowThread.callState(state198, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 639, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 639, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 642
			try {
				count = getCount(2054067225) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(2054067225);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 643
						String sss = event.get("text").toString();
						// Line: 644
						if (eq("Sorry",info.callroom_CN(sss))) {
							iristk.situated.SystemAgentFlow.say state200 = agent.new say();
							StringCreator string201 = new StringCreator();
							string201.append("抱歉，我没有理解您说的话。");
							state200.setText(string201.toString());
							if (!flowThread.callState(state200, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 644, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 646
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 646, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 647
						} else {
							iristk.situated.SystemAgentFlow.say state202 = agent.new say();
							state202.setText(info.callroom_CN(sss));
							if (!flowThread.callState(state202, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 644, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 649
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 650
							roomconfirm_CN state203 = new roomconfirm_CN();
							flowThread.gotoState(state203, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 650, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 642, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class roomconfirm_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 656
			try {
				EXECUTION: {
					int count = getCount(1967802297) + 1;
					incrCount(1967802297);
					iristk.situated.SystemAgentFlow.listen state204 = agent.new listen();
					if (!flowThread.callState(state204, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 656, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 656, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 659
			try {
				count = getCount(2009368120) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2009368120);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 660
							call.remove("room");
							// Line: 661
							callroom_CN state205 = new callroom_CN();
							flowThread.gotoState(state205, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 661, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 659, 57));
			}
			// Line: 663
			try {
				count = getCount(1066680028) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1066680028);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 664
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 667
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 668
							CheckAgain_CN state206 = new CheckAgain_CN();
							flowThread.gotoState(state206, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 668, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 663, 58));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class CheckAgain_CN extends Dialog_CN {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 677
			try {
				EXECUTION: {
					int count = getCount(1391463689) + 1;
					incrCount(1391463689);
					iristk.situated.SystemAgentFlow.prompt state207 = agent.new prompt();
					StringCreator string208 = new StringCreator();
					string208.append("您还需要其他帮助吗？");
					state207.setText(string208.toString());
					if (!flowThread.callState(state207, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 677, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 677, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 680
			try {
				count = getCount(1460340425) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1460340425);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state209 = agent.new say();
							StringCreator string210 = new StringCreator();
							string210.append("好的");
							state209.setText(string210.toString());
							if (!flowThread.callState(state209, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 680, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 682
							Start_CN state211 = new Start_CN();
							flowThread.gotoState(state211, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 682, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 680, 58));
			}
			// Line: 684
			try {
				count = getCount(752387627) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(752387627);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state212 = agent.new say();
							StringCreator string213 = new StringCreator();
							string213.append("好的");
							state212.setText(string213.toString());
							if (!flowThread.callState(state212, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 684, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 686
							Goodbye_CN state214 = new Goodbye_CN();
							flowThread.gotoState(state214, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 686, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 684, 57));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog_CN extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 691
			try {
				count = getCount(1533264279) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1533264279);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state215 = agent.new gesture();
							state215.setName("smile");
							if (!flowThread.callState(state215, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 691, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 691, 102));
			}
			// Line: 694
			try {
				count = getCount(870509838) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(870509838);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state216 = agent.new say();
						StringCreator string217 = new StringCreator();
						string217.append("抱歉，我没有理解您说的话。");
						state216.setText(string217.toString());
						if (!flowThread.callState(state216, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 694, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 696
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 696, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 694, 36));
			}
			// Line: 698
			try {
				count = getCount(791606414) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(791606414);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state218 = agent.new attendOther();
						state218.setMode("eyes");
						if (!flowThread.callState(state218, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 698, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state219 = agent.new say();
						StringCreator string220 = new StringCreator();
						string220.append("对不起，我现在没有问您。");
						state219.setText(string220.toString());
						if (!flowThread.callState(state219, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 698, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state221 = agent.new attendOther();
						state221.setMode("eyes");
						if (!flowThread.callState(state221, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 698, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 702
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 702, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 698, 41));
			}
			// Line: 704
			try {
				count = getCount(1319824710) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(1319824710);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state222 = agent.new say();
						StringCreator string223 = new StringCreator();
						string223.append("请不要同时说话。");
						state222.setText(string223.toString());
						if (!flowThread.callState(state222, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 704, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 706
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 706, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 704, 42));
			}
			// Line: 708
			try {
				count = getCount(278178177) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(278178177);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state224 = agent.new say();
						StringCreator string225 = new StringCreator();
						string225.append("抱歉，我没有听到任何话。");
						state224.setText(string225.toString());
						if (!flowThread.callState(state224, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 708, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 710
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 710, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 708, 38));
			}
			// Line: 712
			try {
				count = getCount(1144576766) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1144576766);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state226 = agent.new say();
							StringCreator string227 = new StringCreator();
							string227.append("再见。");
							state226.setText(string227.toString());
							if (!flowThread.callState(state226, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 712, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 714
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state228 = agent.new attendRandom();
								if (!flowThread.callState(state228, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 714, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 716
								Start_CN state229 = new Start_CN();
								flowThread.gotoState(state229, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 716, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 717
							} else {
								// Line: 718
								Idle state230 = new Idle();
								flowThread.gotoState(state230, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 718, 25)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 712, 69));
			}
			// Line: 721
			try {
				count = getCount(1516342527) + 1;
				if (event.triggers("repeat")) {
					incrCount(1516342527);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 722
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 722, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 721, 26));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
