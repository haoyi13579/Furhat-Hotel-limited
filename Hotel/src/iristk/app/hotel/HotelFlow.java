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
					int count = getCount(254792595) + 1;
					incrCount(254792595);
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
				count = getCount(194070160) + 1;
				if (event.triggers("sense.user.enter")) {
					incrCount(194070160);
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
					int count = getCount(1819147102) + 1;
					incrCount(1819147102);
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
				count = getCount(635602468) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:chinese")) {
						incrCount(635602468);
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
				count = getCount(171652562) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:english")) {
						incrCount(171652562);
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
					int count = getCount(63930885) + 1;
					incrCount(63930885);
					iristk.situated.SystemAgentFlow.prompt state14 = agent.new prompt();
					StringCreator string15 = new StringCreator();
					string15.append("At present, I can help you with: 						tourist attractions recommendation, 						transportation information,  						room location query, 						Weather query, and morning call service");
					state14.setText(string15.toString());
					if (!flowThread.callState(state14, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 57, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.prompt state16 = agent.new prompt();
					StringCreator string17 = new StringCreator();
					string17.append("What can I do for you?");
					state16.setText(string17.toString());
					if (!flowThread.callState(state16, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 57, 12)))) {
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
			// Line: 67
			try {
				count = getCount(563189498) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(563189498);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 69
							if (event.has("sem:natural")) {
								// Line: 70
								Nature state18 = new Nature();
								flowThread.gotoState(state18, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 70, 29)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 71
							} else if (event.has("sem:historical")) {
								// Line: 72
								History state19 = new History();
								flowThread.gotoState(state19, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 72, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 73
							} else if (event.has("sem:popular")) {
								// Line: 74
								Popular state20 = new Popular();
								flowThread.gotoState(state20, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 74, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 75
							} else {
								// Line: 76
								QueryAttr state21 = new QueryAttr();
								flowThread.gotoState(state21, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 76, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 67, 68));
			}
			// Line: 80
			try {
				count = getCount(1352791122) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(1352791122);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 81
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state22 = agent.new say();
								state22.setText(info.transdetail(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state22, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 81, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 83
								CheckAgain state23 = new CheckAgain();
								flowThread.gotoState(state23, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 83, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 84
							} else {
								// Line: 85
								QueryTrans state24 = new QueryTrans();
								flowThread.gotoState(state24, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 85, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 80, 71));
			}
			// Line: 89
			try {
				count = getCount(280463473) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(280463473);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 91
							QueryRoom state25 = new QueryRoom();
							flowThread.gotoState(state25, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 91, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 89, 62));
			}
			// Line: 94
			try {
				count = getCount(837802872) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(837802872);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 95
							QueryWeather state26 = new QueryWeather();
							flowThread.gotoState(state26, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 95, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 94, 62));
			}
			// Line: 98
			try {
				count = getCount(949695546) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(949695546);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 99
							MorningCall state27 = new MorningCall();
							flowThread.gotoState(state27, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 99, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 98, 59));
			}
			// Line: 102
			try {
				count = getCount(438087777) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(438087777);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state28 = agent.new say();
							StringCreator string29 = new StringCreator();
							string29.append("Okay");
							state28.setText(string29.toString());
							if (!flowThread.callState(state28, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 102, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 104
							Goodbye state30 = new Goodbye();
							flowThread.gotoState(state30, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 104, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 102, 59));
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
			// Line: 112
			try {
				EXECUTION: {
					int count = getCount(406540677) + 1;
					incrCount(406540677);
					iristk.situated.SystemAgentFlow.say state31 = agent.new say();
					StringCreator string32 = new StringCreator();
					string32.append("Goodbye.");
					state31.setText(string32.toString());
					if (!flowThread.callState(state31, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state33 = agent.new say();
					StringCreator string34 = new StringCreator();
					string34.append("Please leave the detection area");
					state33.setText(string34.toString());
					if (!flowThread.callState(state33, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 112, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 115
					iristk.flow.DialogFlow.wait waitState35 = new iristk.flow.DialogFlow.wait();
					waitState35.setMsec(4000);
					if (!flowThread.callState(waitState35, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 115, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 116
					Idle state36 = new Idle();
					flowThread.gotoState(state36, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 116, 24)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 112, 12));
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
			// Line: 123
			try {
				EXECUTION: {
					int count = getCount(447504435) + 1;
					incrCount(447504435);
					iristk.situated.SystemAgentFlow.prompt state37 = agent.new prompt();
					StringCreator string38 = new StringCreator();
					string38.append("What kind of tourist attractions do you want to visit? Natural, historical or popular?");
					state37.setText(string38.toString());
					if (!flowThread.callState(state37, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 123, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 123, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 128
			try {
				count = getCount(643907456) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(643907456);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 129
							Nature state39 = new Nature();
							flowThread.gotoState(state39, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 129, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 128, 68));
			}
			// Line: 131
			try {
				count = getCount(557302482) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(557302482);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 132
							History state40 = new History();
							flowThread.gotoState(state40, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 132, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 131, 71));
			}
			// Line: 134
			try {
				count = getCount(1283005480) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(1283005480);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 135
							Popular state41 = new Popular();
							flowThread.gotoState(state41, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 135, 33)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 134, 66));
			}
			// Line: 137
			try {
				count = getCount(394317841) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(394317841);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 138
							CheckAgain state42 = new CheckAgain();
							flowThread.gotoState(state42, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 138, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 137, 61));
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
			// Line: 143
			try {
				EXECUTION: {
					int count = getCount(1263121765) + 1;
					incrCount(1263121765);
					iristk.situated.SystemAgentFlow.say state43 = agent.new say();
					state43.setText(info.recommend(info.readattr(),"Natural"));
					if (!flowThread.callState(state43, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 143, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 145
					Attrdetial state44 = new Attrdetial();
					flowThread.gotoState(state44, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 145, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 143, 16));
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
			// Line: 150
			try {
				EXECUTION: {
					int count = getCount(943165198) + 1;
					incrCount(943165198);
					iristk.situated.SystemAgentFlow.say state45 = agent.new say();
					state45.setText(info.recommend(info.readattr(),"Historical"));
					if (!flowThread.callState(state45, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 150, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 152
					Attrdetial state46 = new Attrdetial();
					flowThread.gotoState(state46, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 152, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 150, 16));
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
			// Line: 157
			try {
				EXECUTION: {
					int count = getCount(1796072292) + 1;
					incrCount(1796072292);
					iristk.situated.SystemAgentFlow.say state47 = agent.new say();
					state47.setText(info.popular(info.readattr()));
					if (!flowThread.callState(state47, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 157, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 159
					Attrdetial state48 = new Attrdetial();
					flowThread.gotoState(state48, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 159, 34)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 157, 16));
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
			// Line: 164
			try {
				EXECUTION: {
					int count = getCount(1259983601) + 1;
					incrCount(1259983601);
					iristk.situated.SystemAgentFlow.prompt state49 = agent.new prompt();
					StringCreator string50 = new StringCreator();
					string50.append("If you want more details for attractions,please say the name.");
					state49.setText(string50.toString());
					if (!flowThread.callState(state49, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 164, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 164, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 167
			try {
				count = getCount(385160344) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(385160344);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 168
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state51 = agent.new say();
							state51.setText(info.detail(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state51, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 167, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 170
							CheckAgain state52 = new CheckAgain();
							flowThread.gotoState(state52, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 170, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 167, 69));
			}
			// Line: 172
			try {
				count = getCount(774066383) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(774066383);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 173
							CheckAgain state53 = new CheckAgain();
							flowThread.gotoState(state53, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 173, 36)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 172, 61));
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
			// Line: 179
			try {
				EXECUTION: {
					int count = getCount(22504470) + 1;
					incrCount(22504470);
					iristk.situated.SystemAgentFlow.prompt state54 = agent.new prompt();
					StringCreator string55 = new StringCreator();
					string55.append("Where do you want to go?");
					state54.setText(string55.toString());
					if (!flowThread.callState(state54, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 179, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 179, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 182
			try {
				count = getCount(1404327848) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(1404327848);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state56 = agent.new say();
							state56.setText(event.get("sem:attrname"));
							if (!flowThread.callState(state56, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 182, 65)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							iristk.situated.SystemAgentFlow.say state57 = agent.new say();
							state57.setText(info.transdetail(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state57, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 182, 65)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 185
							CheckAgain state58 = new CheckAgain();
							flowThread.gotoState(state58, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 185, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 182, 65));
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
			// Line: 191
			try {
				EXECUTION: {
					int count = getCount(338852699) + 1;
					incrCount(338852699);
					iristk.situated.SystemAgentFlow.prompt state59 = agent.new prompt();
					StringCreator string60 = new StringCreator();
					string60.append("Which room do you want to find?");
					state59.setText(string60.toString());
					if (!flowThread.callState(state59, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 191, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 191, 16));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 194
			try {
				count = getCount(1707763554) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(1707763554);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state61 = agent.new say();
							StringCreator string62 = new StringCreator();
							string62.append("It is on the first floor");
							state61.setText(string62.toString());
							if (!flowThread.callState(state61, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 194, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 196
							CheckAgain state63 = new CheckAgain();
							flowThread.gotoState(state63, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 196, 34)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 194, 70));
			}
			// Line: 198
			try {
				count = getCount(845336064) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(845336064);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 199
						String ss = event.get("text").toString();
						// Line: 200
						if (eq("Sorry",info.findroom(ss))) {
							iristk.situated.SystemAgentFlow.say state64 = agent.new say();
							StringCreator string65 = new StringCreator();
							string65.append("Sorry, I didn't get that.");
							state64.setText(string65.toString());
							if (!flowThread.callState(state64, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 200, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 202
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 202, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 203
						} else {
							iristk.situated.SystemAgentFlow.say state66 = agent.new say();
							state66.setText(info.findroom(ss));
							if (!flowThread.callState(state66, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 200, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 205
							CheckAgain state67 = new CheckAgain();
							flowThread.gotoState(state67, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 205, 35)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 198, 42));
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
			// Line: 212
			try {
				EXECUTION: {
					int count = getCount(828397489) + 1;
					incrCount(828397489);
					iristk.situated.SystemAgentFlow.say state68 = agent.new say();
					state68.setText(weather.getweather());
					if (!flowThread.callState(state68, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 212, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 214
					CheckAgain state69 = new CheckAgain();
					flowThread.gotoState(state69, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 214, 30)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 212, 12));
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
			// Line: 220
			try {
				EXECUTION: {
					int count = getCount(1278632812) + 1;
					incrCount(1278632812);
					// Line: 221
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					// Line: 222
					checkcall state70 = new checkcall();
					flowThread.gotoState(state70, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 222, 29)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 220, 12));
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
			// Line: 227
			try {
				EXECUTION: {
					int count = getCount(1103543842) + 1;
					incrCount(1103543842);
					// Line: 228
					if (!call.has("hour")) {
						// Line: 229
						askhour state71 = new askhour();
						flowThread.gotoState(state71, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 229, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 230
					} else if (!call.has("minute")) {
						// Line: 231
						askminute state72 = new askminute();
						flowThread.gotoState(state72, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 231, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 232
					} else if (!call.has("apm")) {
						// Line: 233
						askapm state73 = new askapm();
						flowThread.gotoState(state73, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 233, 27)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 234
					} else if (!call.has("date")) {
						// Line: 235
						askdate state74 = new askdate();
						flowThread.gotoState(state74, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 235, 28)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 236
					} else {
						// Line: 237
						calldone state75 = new calldone();
						flowThread.gotoState(state75, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 237, 29)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 227, 12));
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
			// Line: 243
			try {
				EXECUTION: {
					int count = getCount(374122681) + 1;
					incrCount(374122681);
					iristk.situated.SystemAgentFlow.prompt state76 = agent.new prompt();
					StringCreator string77 = new StringCreator();
					string77.append("Please say the hour of the morning call.");
					state76.setText(string77.toString());
					if (!flowThread.callState(state76, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 243, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 243, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 246
			try {
				count = getCount(1477771378) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1477771378);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 247
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 248
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state78 = agent.new say();
								StringCreator string79 = new StringCreator();
								string79.append("Sorry the time is invalid.");
								state78.setText(string79.toString());
								if (!flowThread.callState(state78, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 248, 29)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 250
							} else if ( num > 11 ) {
								// Line: 251
								call.putIfNotNull("hour", event.get("sem:number")); call.putIfNotNull("apm", "pm");
								// Line: 252
							} else {
								// Line: 253
								call.putIfNotNull("hour", event.get("sem:number"));
							}
							// Line: 255
							checkcall state80 = new checkcall();
							flowThread.gotoState(state80, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 255, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 246, 61));
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
			// Line: 260
			try {
				EXECUTION: {
					int count = getCount(362660037) + 1;
					incrCount(362660037);
					iristk.situated.SystemAgentFlow.prompt state81 = agent.new prompt();
					StringCreator string82 = new StringCreator();
					string82.append("Please say the minute of the morning call.");
					state81.setText(string82.toString());
					if (!flowThread.callState(state81, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 260, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 260, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 263
			try {
				count = getCount(328480255) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(328480255);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 264
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 265
							checkcall state83 = new checkcall();
							flowThread.gotoState(state83, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 265, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 263, 61));
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
			// Line: 270
			try {
				EXECUTION: {
					int count = getCount(1002038489) + 1;
					incrCount(1002038489);
					iristk.situated.SystemAgentFlow.prompt state84 = agent.new prompt();
					StringCreator string85 = new StringCreator();
					string85.append("Is it a.m. or p.m.?");
					state84.setText(string85.toString());
					if (!flowThread.callState(state84, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 270, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 270, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 273
			try {
				count = getCount(1074322669) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(1074322669);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 274
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 275
							checkcall state86 = new checkcall();
							flowThread.gotoState(state86, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 275, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 273, 58));
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
			// Line: 280
			try {
				EXECUTION: {
					int count = getCount(1249471188) + 1;
					incrCount(1249471188);
					iristk.situated.SystemAgentFlow.prompt state87 = agent.new prompt();
					StringCreator string88 = new StringCreator();
					string88.append("Do we need to call you at today or tomorrow?");
					state87.setText(string88.toString());
					if (!flowThread.callState(state87, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 280, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 280, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 283
			try {
				count = getCount(428727292) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(428727292);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 284
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 285
							checkcall state89 = new checkcall();
							flowThread.gotoState(state89, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 285, 29)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 283, 59));
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
			// Line: 290
			try {
				EXECUTION: {
					int count = getCount(1180951425) + 1;
					incrCount(1180951425);
					// Line: 291
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state90 = agent.new prompt();
					state90.setText(info.timeconfirm(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state90, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 290, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 290, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 295
			try {
				count = getCount(1738542131) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1738542131);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 296
							callroom state91 = new callroom();
							flowThread.gotoState(state91, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 296, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 295, 58));
			}
			// Line: 298
			try {
				count = getCount(992395775) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(992395775);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 299
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 300
							MorningCall state92 = new MorningCall();
							flowThread.gotoState(state92, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 300, 31)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 298, 57));
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
			// Line: 305
			try {
				EXECUTION: {
					int count = getCount(629945836) + 1;
					incrCount(629945836);
					iristk.situated.SystemAgentFlow.prompt state93 = agent.new prompt();
					StringCreator string94 = new StringCreator();
					string94.append("Which room do you live in?");
					state93.setText(string94.toString());
					if (!flowThread.callState(state93, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 305, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 305, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 308
			try {
				count = getCount(213362067) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(213362067);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 309
						String sss = event.get("text").toString();
						// Line: 310
						if (eq("Sorry",info.callroom(sss))) {
							iristk.situated.SystemAgentFlow.say state95 = agent.new say();
							StringCreator string96 = new StringCreator();
							string96.append("Sorry, I didn't get that.");
							state95.setText(string96.toString());
							if (!flowThread.callState(state95, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 310, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 312
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 312, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 313
						} else {
							iristk.situated.SystemAgentFlow.say state97 = agent.new say();
							state97.setText(info.callroom(sss));
							if (!flowThread.callState(state97, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 310, 46)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 315
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 316
							roomconfirm state98 = new roomconfirm();
							flowThread.gotoState(state98, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 316, 32)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 308, 36));
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
			// Line: 322
			try {
				EXECUTION: {
					int count = getCount(1711520328) + 1;
					incrCount(1711520328);
					iristk.situated.SystemAgentFlow.listen state99 = agent.new listen();
					if (!flowThread.callState(state99, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 322, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 322, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 325
			try {
				count = getCount(419751808) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(419751808);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 326
							call.remove("room");
							// Line: 327
							callroom state100 = new callroom();
							flowThread.gotoState(state100, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 327, 28)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 325, 57));
			}
			// Line: 329
			try {
				count = getCount(1462451380) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1462451380);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 330
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 333
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 334
							CheckAgain state101 = new CheckAgain();
							flowThread.gotoState(state101, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 334, 30)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 329, 58));
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
			// Line: 342
			try {
				EXECUTION: {
					int count = getCount(2094452740) + 1;
					incrCount(2094452740);
					iristk.situated.SystemAgentFlow.prompt state102 = agent.new prompt();
					StringCreator string103 = new StringCreator();
					string103.append("Do you need other help?");
					state102.setText(string103.toString());
					if (!flowThread.callState(state102, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 342, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 342, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 345
			try {
				count = getCount(1042183523) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1042183523);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state104 = agent.new say();
							StringCreator string105 = new StringCreator();
							string105.append("Okay");
							state104.setText(string105.toString());
							if (!flowThread.callState(state104, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 345, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 347
							Start state106 = new Start();
							flowThread.gotoState(state106, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 347, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 345, 58));
			}
			// Line: 349
			try {
				count = getCount(851521553) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(851521553);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state107 = agent.new say();
							StringCreator string108 = new StringCreator();
							string108.append("Okay");
							state107.setText(string108.toString());
							if (!flowThread.callState(state107, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 349, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 351
							Goodbye state109 = new Goodbye();
							flowThread.gotoState(state109, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 351, 27)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 349, 57));
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
			// Line: 356
			try {
				count = getCount(1112603333) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(1112603333);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state110 = agent.new gesture();
							state110.setName("smile");
							if (!flowThread.callState(state110, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 356, 102)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 356, 102));
			}
			// Line: 359
			try {
				count = getCount(2032802598) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(2032802598);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state111 = agent.new say();
						StringCreator string112 = new StringCreator();
						string112.append("Sorry, I didn't get that.");
						state111.setText(string112.toString());
						if (!flowThread.callState(state111, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 359, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 361
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 361, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 359, 36));
			}
			// Line: 363
			try {
				count = getCount(1927395029) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1927395029);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state113 = agent.new attendOther();
						state113.setMode("eyes");
						if (!flowThread.callState(state113, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 363, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state114 = agent.new say();
						StringCreator string115 = new StringCreator();
						string115.append("I didn't ask you.");
						state114.setText(string115.toString());
						if (!flowThread.callState(state114, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 363, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state116 = agent.new attendOther();
						state116.setMode("eyes");
						if (!flowThread.callState(state116, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 363, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 367
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 367, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 363, 41));
			}
			// Line: 369
			try {
				count = getCount(511193719) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(511193719);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state117 = agent.new say();
						StringCreator string118 = new StringCreator();
						string118.append("Don't speak at the same time.");
						state117.setText(string118.toString());
						if (!flowThread.callState(state117, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 369, 42)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 371
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 371, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 369, 42));
			}
			// Line: 373
			try {
				count = getCount(1028433149) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1028433149);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state119 = agent.new say();
						StringCreator string120 = new StringCreator();
						string120.append("Sorry, I didn't hear anything.");
						state119.setText(string120.toString());
						if (!flowThread.callState(state119, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 373, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 375
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 375, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 373, 38));
			}
			// Line: 377
			try {
				count = getCount(1109269406) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1109269406);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state121 = agent.new say();
							StringCreator string122 = new StringCreator();
							string122.append("Goodbye");
							state121.setText(string122.toString());
							if (!flowThread.callState(state121, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 377, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 383
							Idle state123 = new Idle();
							flowThread.gotoState(state123, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 383, 25)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 377, 69));
			}
			// Line: 386
			try {
				count = getCount(2131184197) + 1;
				if (event.triggers("repeat")) {
					incrCount(2131184197);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 387
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 387, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 386, 26));
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
			// Line: 399
			try {
				EXECUTION: {
					int count = getCount(119919210) + 1;
					incrCount(119919210);
					iristk.situated.SystemAgentFlow.prompt state124 = agent.new prompt();
					StringCreator string125 = new StringCreator();
					string125.append("现在我可以帮您的有：  				景点推荐，交通查询，房间位置查询，天气查询以及叫醒服务预定。");
					state124.setText(string125.toString());
					if (!flowThread.callState(state124, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 399, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.prompt state126 = agent.new prompt();
					StringCreator string127 = new StringCreator();
					string127.append("请问有什么可以帮到您的？");
					state126.setText(string127.toString());
					if (!flowThread.callState(state126, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 399, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 399, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 405
			try {
				count = getCount(1110828457) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attractions")) {
						incrCount(1110828457);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 407
							if (event.has("sem:natural")) {
								// Line: 408
								Nature_CN state128 = new Nature_CN();
								flowThread.gotoState(state128, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 408, 32)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 409
							} else if (event.has("sem:historical")) {
								// Line: 410
								History_CN state129 = new History_CN();
								flowThread.gotoState(state129, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 410, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 411
							} else if (event.has("sem:popular")) {
								// Line: 412
								Popular_CN state130 = new Popular_CN();
								flowThread.gotoState(state130, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 412, 33)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 413
							} else {
								// Line: 414
								QueryAttr_CN state131 = new QueryAttr_CN();
								flowThread.gotoState(state131, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 414, 35)));
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
				count = getCount(233490276) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:transportation")) {
						incrCount(233490276);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 419
							if (event.has("sem:attra")) {
								iristk.situated.SystemAgentFlow.say state132 = agent.new say();
								state132.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attra")));
								if (!flowThread.callState(state132, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 419, 32)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 421
								CheckAgain_CN state133 = new CheckAgain_CN();
								flowThread.gotoState(state133, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 421, 36)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 422
							} else {
								// Line: 423
								QueryTrans_CN state134 = new QueryTrans_CN();
								flowThread.gotoState(state134, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 423, 36)));
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
				count = getCount(1490853441) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:rooms")) {
						incrCount(1490853441);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 428
							QueryRoom_CN state135 = new QueryRoom_CN();
							flowThread.gotoState(state135, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 428, 34)));
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
				count = getCount(1210352754) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:weather")) {
						incrCount(1210352754);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 432
							QueryWeather_CN state136 = new QueryWeather_CN();
							flowThread.gotoState(state136, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 432, 37)));
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
				count = getCount(1126832964) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:call")) {
						incrCount(1126832964);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 436
							MorningCall_CN state137 = new MorningCall_CN();
							flowThread.gotoState(state137, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 436, 36)));
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
				count = getCount(151459667) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:no")) {
						incrCount(151459667);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state138 = agent.new say();
							StringCreator string139 = new StringCreator();
							string139.append("好的");
							state138.setText(string139.toString());
							if (!flowThread.callState(state138, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 439, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 441
							Goodbye_CN state140 = new Goodbye_CN();
							flowThread.gotoState(state140, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 441, 30)));
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
					int count = getCount(631797960) + 1;
					incrCount(631797960);
					iristk.situated.SystemAgentFlow.say state141 = agent.new say();
					StringCreator string142 = new StringCreator();
					string142.append("再见。");
					state141.setText(string142.toString());
					if (!flowThread.callState(state141, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 448, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					iristk.situated.SystemAgentFlow.say state143 = agent.new say();
					StringCreator string144 = new StringCreator();
					string144.append("请离开感应区域");
					state143.setText(string144.toString());
					if (!flowThread.callState(state143, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 448, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 451
					iristk.flow.DialogFlow.wait waitState145 = new iristk.flow.DialogFlow.wait();
					waitState145.setMsec(2000);
					if (!flowThread.callState(waitState145, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 451, 23)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 452
					Idle state146 = new Idle();
					flowThread.gotoState(state146, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 452, 24)));
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
					int count = getCount(2141869454) + 1;
					incrCount(2141869454);
					iristk.situated.SystemAgentFlow.prompt state147 = agent.new prompt();
					StringCreator string148 = new StringCreator();
					string148.append("您想参观哪种景点？自然景点，历史景点还是热门景点？");
					state147.setText(string148.toString());
					if (!flowThread.callState(state147, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 459, 16)))) {
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
				count = getCount(1238228380) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:natural")) {
						incrCount(1238228380);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 465
							Nature_CN state149 = new Nature_CN();
							flowThread.gotoState(state149, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 465, 35)));
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
				count = getCount(203035049) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:historical")) {
						incrCount(203035049);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 468
							History_CN state150 = new History_CN();
							flowThread.gotoState(state150, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 468, 36)));
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
				count = getCount(112671510) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:popular")) {
						incrCount(112671510);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 471
							Popular_CN state151 = new Popular_CN();
							flowThread.gotoState(state151, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 471, 36)));
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
				count = getCount(1155073278) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1155073278);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 474
							CheckAgain_CN state152 = new CheckAgain_CN();
							flowThread.gotoState(state152, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 474, 39)));
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
					int count = getCount(1574439453) + 1;
					incrCount(1574439453);
					iristk.situated.SystemAgentFlow.say state153 = agent.new say();
					state153.setText(info.recommend_CN(info.readattr(),"Natural"));
					if (!flowThread.callState(state153, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 479, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 481
					Attrdetial_CN state154 = new Attrdetial_CN();
					flowThread.gotoState(state154, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 481, 37)));
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
					int count = getCount(1770670947) + 1;
					incrCount(1770670947);
					iristk.situated.SystemAgentFlow.say state155 = agent.new say();
					state155.setText(info.recommend_CN(info.readattr(),"Historical"));
					if (!flowThread.callState(state155, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 486, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 488
					Attrdetial_CN state156 = new Attrdetial_CN();
					flowThread.gotoState(state156, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 488, 37)));
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
					int count = getCount(1804766265) + 1;
					incrCount(1804766265);
					iristk.situated.SystemAgentFlow.say state157 = agent.new say();
					state157.setText(info.popular_CN(info.readattr()));
					if (!flowThread.callState(state157, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 493, 16)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 495
					Attrdetial_CN state158 = new Attrdetial_CN();
					flowThread.gotoState(state158, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 495, 37)));
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
					int count = getCount(1697240227) + 1;
					incrCount(1697240227);
					iristk.situated.SystemAgentFlow.prompt state159 = agent.new prompt();
					StringCreator string160 = new StringCreator();
					string160.append("如果您想了解某个景点的详情，请说出该景点的名字。");
					state159.setText(string160.toString());
					if (!flowThread.callState(state159, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 500, 16)))) {
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
				count = getCount(438665083) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:attrname")) {
						incrCount(438665083);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 504
							String s = event.get("text").toString();
							iristk.situated.SystemAgentFlow.say state161 = agent.new say();
							state161.setText(info.detail_CN(info.readattr(),event.get("sem:attrname")));
							if (!flowThread.callState(state161, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 503, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 506
							CheckAgain_CN state162 = new CheckAgain_CN();
							flowThread.gotoState(state162, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 506, 37)));
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
				count = getCount(31652912) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(31652912);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 509
							CheckAgain_CN state163 = new CheckAgain_CN();
							flowThread.gotoState(state163, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 509, 39)));
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
					int count = getCount(256753772) + 1;
					incrCount(256753772);
					iristk.situated.SystemAgentFlow.prompt state164 = agent.new prompt();
					StringCreator string165 = new StringCreator();
					string165.append("您打算去哪里？");
					state164.setText(string165.toString());
					if (!flowThread.callState(state164, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 515, 12)))) {
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
				count = getCount(425246409) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:attrname")) {
						incrCount(425246409);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state166 = agent.new say();
							state166.setText(info.transdetail_CN(info.readtrans(),event.get("sem:attrname")));
							if (!flowThread.callState(state166, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 518, 63)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 520
							CheckAgain_CN state167 = new CheckAgain_CN();
							flowThread.gotoState(state167, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 520, 33)));
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
					int count = getCount(311826055) + 1;
					incrCount(311826055);
					iristk.situated.SystemAgentFlow.prompt state168 = agent.new prompt();
					StringCreator string169 = new StringCreator();
					string169.append("您在找哪个房间？");
					state168.setText(string169.toString());
					if (!flowThread.callState(state168, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 526, 16)))) {
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
				count = getCount(1323588842) + 1;
				if (event.triggers("sense.user.speak**")) {
					if (event.has("sem:otherroom")) {
						incrCount(1323588842);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state170 = agent.new say();
							StringCreator string171 = new StringCreator();
							string171.append("它在一楼。");
							state170.setText(string171.toString());
							if (!flowThread.callState(state170, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 529, 70)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 531
							CheckAgain_CN state172 = new CheckAgain_CN();
							flowThread.gotoState(state172, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 531, 37)));
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
				count = getCount(198639860) + 1;
				if (event.triggers("sense.user.speak**")) {
					incrCount(198639860);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 534
						String ss = event.get("text").toString();
						// Line: 535
						if (eq("Sorry",info.findroom_CN(ss))) {
							iristk.situated.SystemAgentFlow.say state173 = agent.new say();
							StringCreator string174 = new StringCreator();
							string174.append("抱歉，我没有理解您说的话。");
							state173.setText(string174.toString());
							if (!flowThread.callState(state173, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 535, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 537
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 537, 19)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 538
						} else {
							iristk.situated.SystemAgentFlow.say state175 = agent.new say();
							state175.setText(info.findroom_CN(ss));
							if (!flowThread.callState(state175, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 535, 52)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 540
							CheckAgain_CN state176 = new CheckAgain_CN();
							flowThread.gotoState(state176, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 540, 38)));
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
					int count = getCount(704777131) + 1;
					incrCount(704777131);
					iristk.situated.SystemAgentFlow.say state177 = agent.new say();
					state177.setText(weather.getweather_CN());
					if (!flowThread.callState(state177, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 547, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 549
					CheckAgain_CN state178 = new CheckAgain_CN();
					flowThread.gotoState(state178, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 549, 33)));
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
					int count = getCount(1992353046) + 1;
					incrCount(1992353046);
					// Line: 555
					call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");call.remove("room");
					// Line: 556
					checkcall_CN state179 = new checkcall_CN();
					flowThread.gotoState(state179, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 556, 32)));
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
					int count = getCount(1997659716) + 1;
					incrCount(1997659716);
					// Line: 562
					if (!call.has("hour")) {
						// Line: 563
						askhour_CN state180 = new askhour_CN();
						flowThread.gotoState(state180, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 563, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 564
					} else if (!call.has("minute")) {
						// Line: 565
						askminute_CN state181 = new askminute_CN();
						flowThread.gotoState(state181, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 565, 33)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 566
					} else if (!call.has("apm")) {
						// Line: 567
						askapm_CN state182 = new askapm_CN();
						flowThread.gotoState(state182, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 567, 30)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 568
					} else if (!call.has("date")) {
						// Line: 569
						askdate_CN state183 = new askdate_CN();
						flowThread.gotoState(state183, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 569, 31)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
						// Line: 570
					} else {
						// Line: 571
						calldone_CN state184 = new calldone_CN();
						flowThread.gotoState(state184, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 571, 32)));
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
					int count = getCount(1286218559) + 1;
					incrCount(1286218559);
					iristk.situated.SystemAgentFlow.prompt state185 = agent.new prompt();
					StringCreator string186 = new StringCreator();
					string186.append("请设置小时数。");
					state185.setText(string186.toString());
					if (!flowThread.callState(state185, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 577, 12)))) {
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
				count = getCount(387262931) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(387262931);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 581
							String tempstring = (event.get("sem:number")).toString(); int num=Integer.valueOf(tempstring);
							// Line: 582
							if ( num > 24 ) {
								iristk.situated.SystemAgentFlow.say state187 = agent.new say();
								StringCreator string188 = new StringCreator();
								string188.append("对不起这是无效的时间。");
								state187.setText(string188.toString());
								if (!flowThread.callState(state187, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 582, 29)))) {
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
							checkcall_CN state189 = new checkcall_CN();
							flowThread.gotoState(state189, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 589, 32)));
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
					int count = getCount(1329457642) + 1;
					incrCount(1329457642);
					iristk.situated.SystemAgentFlow.prompt state190 = agent.new prompt();
					StringCreator string191 = new StringCreator();
					string191.append("请设置分钟数。");
					state190.setText(string191.toString());
					if (!flowThread.callState(state190, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 594, 12)))) {
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
				count = getCount(1693589372) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:number")) {
						incrCount(1693589372);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 598
							call.putIfNotNull("minute", event.get("sem:number"));
							// Line: 599
							checkcall_CN state192 = new checkcall_CN();
							flowThread.gotoState(state192, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 599, 32)));
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
					int count = getCount(89318483) + 1;
					incrCount(89318483);
					iristk.situated.SystemAgentFlow.prompt state193 = agent.new prompt();
					StringCreator string194 = new StringCreator();
					string194.append("请问是上午还是下午?");
					state193.setText(string194.toString());
					if (!flowThread.callState(state193, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 604, 12)))) {
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
				count = getCount(1280556108) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:apm")) {
						incrCount(1280556108);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 608
							call.putIfNotNull("apm", event.get("sem:apm"));
							// Line: 609
							checkcall_CN state195 = new checkcall_CN();
							flowThread.gotoState(state195, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 609, 32)));
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
					int count = getCount(960409623) + 1;
					incrCount(960409623);
					iristk.situated.SystemAgentFlow.prompt state196 = agent.new prompt();
					StringCreator string197 = new StringCreator();
					string197.append("请问是今天还是明天？");
					state196.setText(string197.toString());
					if (!flowThread.callState(state196, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 614, 12)))) {
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
				count = getCount(668442907) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:date")) {
						incrCount(668442907);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 618
							call.putIfNotNull("date", event.get("sem:date"));
							// Line: 619
							checkcall_CN state198 = new checkcall_CN();
							flowThread.gotoState(state198, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 619, 32)));
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
					int count = getCount(1931186516) + 1;
					incrCount(1931186516);
					// Line: 625
					String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
					String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
					iristk.situated.SystemAgentFlow.prompt state199 = agent.new prompt();
					state199.setText(info.timeconfirm_CN(datestring, hourstring, minutestring, apmstring));
					if (!flowThread.callState(state199, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 624, 12)))) {
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
				count = getCount(1309169143) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1309169143);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 630
							callroom_CN state200 = new callroom_CN();
							flowThread.gotoState(state200, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 630, 31)));
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
				count = getCount(2040576607) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(2040576607);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 633
							call.remove("date");call.remove("hour");call.remove("minute");call.remove("apm");
							// Line: 634
							MorningCall_CN state201 = new MorningCall_CN();
							flowThread.gotoState(state201, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 634, 34)));
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
					int count = getCount(612201983) + 1;
					incrCount(612201983);
					iristk.situated.SystemAgentFlow.prompt state202 = agent.new prompt();
					StringCreator string203 = new StringCreator();
					string203.append("请问您的房间号是多少？");
					state202.setText(string203.toString());
					if (!flowThread.callState(state202, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 639, 12)))) {
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
				count = getCount(1760878822) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(1760878822);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						// Line: 643
						String sss = event.get("text").toString();
						// Line: 644
						if (eq("Sorry",info.callroom_CN(sss))) {
							iristk.situated.SystemAgentFlow.say state204 = agent.new say();
							StringCreator string205 = new StringCreator();
							string205.append("抱歉，我没有理解您说的话。");
							state204.setText(string205.toString());
							if (!flowThread.callState(state204, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 644, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 646
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 646, 15)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
							// Line: 647
						} else {
							iristk.situated.SystemAgentFlow.say state206 = agent.new say();
							state206.setText(info.callroom_CN(sss));
							if (!flowThread.callState(state206, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 644, 49)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 649
							call.putIfNotNull("room", info.getcallroomnum(sss));
							// Line: 650
							roomconfirm_CN state207 = new roomconfirm_CN();
							flowThread.gotoState(state207, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 650, 35)));
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
					int count = getCount(1772131998) + 1;
					incrCount(1772131998);
					iristk.situated.SystemAgentFlow.listen state208 = agent.new listen();
					if (!flowThread.callState(state208, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 656, 12)))) {
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
				count = getCount(1205830073) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1205830073);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 660
							call.remove("room");
							// Line: 661
							callroom_CN state209 = new callroom_CN();
							flowThread.gotoState(state209, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 661, 31)));
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
				count = getCount(1555618299) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1555618299);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 664
							String datestring=(call.get("date")).toString(); String hourstring=(call.get("hour")).toString();
							String minutestring=(call.get("minute")).toString(); String apmstring=(call.get("apm")).toString();
							String roomstring=(call.get("room")).toString();
							// Line: 667
							info.addcsv(datestring, hourstring, minutestring, apmstring, roomstring);
							// Line: 668
							CheckAgain_CN state210 = new CheckAgain_CN();
							flowThread.gotoState(state210, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 668, 33)));
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
					int count = getCount(1754768465) + 1;
					incrCount(1754768465);
					iristk.situated.SystemAgentFlow.prompt state211 = agent.new prompt();
					StringCreator string212 = new StringCreator();
					string212.append("您还需要其他帮助吗？");
					state211.setText(string212.toString());
					if (!flowThread.callState(state211, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 677, 12)))) {
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
				count = getCount(1043893361) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:yes")) {
						incrCount(1043893361);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state213 = agent.new say();
							StringCreator string214 = new StringCreator();
							string214.append("好的");
							state213.setText(string214.toString());
							if (!flowThread.callState(state213, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 680, 58)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 682
							Start_CN state215 = new Start_CN();
							flowThread.gotoState(state215, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 682, 28)));
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
				count = getCount(1334635994) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:no")) {
						incrCount(1334635994);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state216 = agent.new say();
							StringCreator string217 = new StringCreator();
							string217.append("好的");
							state216.setText(string217.toString());
							if (!flowThread.callState(state216, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 684, 57)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 686
							Goodbye_CN state218 = new Goodbye_CN();
							flowThread.gotoState(state218, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 686, 30)));
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
				count = getCount(811466733) + 1;
				if (event.triggers("sense.user.speech.start")) {
					if (system.isAttending(event) && eq(event.get("speakers"), 1)) {
						incrCount(811466733);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.gesture state219 = agent.new gesture();
							state219.setName("smile");
							if (!flowThread.callState(state219, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 691, 102)))) {
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
				count = getCount(412562945) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(412562945);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state220 = agent.new say();
						StringCreator string221 = new StringCreator();
						string221.append("抱歉，我没有理解您说的话。");
						state220.setText(string221.toString());
						if (!flowThread.callState(state220, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 694, 36)))) {
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
				count = getCount(1755833626) + 1;
				if (event.triggers("sense.user.speak.side")) {
					incrCount(1755833626);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.attendOther state222 = agent.new attendOther();
						state222.setMode("eyes");
						if (!flowThread.callState(state222, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 698, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.say state223 = agent.new say();
						StringCreator string224 = new StringCreator();
						string224.append("对不起，我现在没有问您。");
						state223.setText(string224.toString());
						if (!flowThread.callState(state223, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 698, 41)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						iristk.situated.SystemAgentFlow.attendOther state225 = agent.new attendOther();
						state225.setMode("eyes");
						if (!flowThread.callState(state225, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 698, 41)))) {
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
				count = getCount(375177888) + 1;
				if (event.triggers("sense.user.speak.multi")) {
					incrCount(375177888);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state226 = agent.new say();
						StringCreator string227 = new StringCreator();
						string227.append("请不要同时说话。");
						state226.setText(string227.toString());
						if (!flowThread.callState(state226, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 704, 42)))) {
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
				count = getCount(1740557934) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1740557934);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.situated.SystemAgentFlow.say state228 = agent.new say();
						StringCreator string229 = new StringCreator();
						string229.append("抱歉，我没有听到任何话。");
						state228.setText(string229.toString());
						if (!flowThread.callState(state228, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 708, 38)))) {
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
				count = getCount(1985451311) + 1;
				if (event.triggers("sense.user.leave")) {
					if (system.isAttending(event)) {
						incrCount(1985451311);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.situated.SystemAgentFlow.say state230 = agent.new say();
							StringCreator string231 = new StringCreator();
							string231.append("再见。");
							state230.setText(string231.toString());
							if (!flowThread.callState(state230, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 712, 69)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 714
							if (system.hasUsers()) {
								iristk.situated.SystemAgentFlow.attendRandom state232 = agent.new attendRandom();
								if (!flowThread.callState(state232, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 714, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
								// Line: 716
								Start_CN state233 = new Start_CN();
								flowThread.gotoState(state233, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 716, 30)));
								eventResult = EVENT_ABORTED;
								break EXECUTION;
								// Line: 717
							} else {
								// Line: 718
								Idle state234 = new Idle();
								flowThread.gotoState(state234, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("E:\\furhatsdk\\app\\Hotel\\src\\iristk\\app\\hotel\\HotelFlow.xml"), 718, 25)));
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
				count = getCount(786424452) + 1;
				if (event.triggers("repeat")) {
					incrCount(786424452);
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
