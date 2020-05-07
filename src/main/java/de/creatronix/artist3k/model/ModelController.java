package de.creatronix.artist3k.model;

public class ModelController {

	private EventManager eventManager;
	private UserManager userManager;
	private LocationManager locationManager;
	private OrganizerManager organizerManager;
	private StageActManager stageActManager;
	private ApplicationManager applicationManager;
	private CalendarManager calendarManager;
	private AddressManager addressManager;
	private static ModelController instance;

	public static ModelController getInstance() {
		if (instance == null) {
			instance = new ModelController();
		}
		return instance;
	}

	private ModelController() {
		eventManager = new EventManager();
		userManager = new UserManager();
		locationManager = new LocationManager();
		organizerManager = new OrganizerManager();
		stageActManager = new StageActManager();
		applicationManager = new ApplicationManager();
		calendarManager = new CalendarManager();
		addressManager = new AddressManager();
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public LocationManager getLocationManager() {
		return locationManager;
	}

	public OrganizerManager getOrganizerManager() {
		return organizerManager;
	}

	public StageActManager getStageActManager() {
		return stageActManager;
	}

	public ApplicationManager getApplicationManager() {
		return applicationManager;
	}

	public CalendarManager getCalendarManager() {
		// TODO Auto-generated method stub
		return calendarManager;
	}

	public AddressManager getAddressManager() {
		// TODO Auto-generated method stub
		return addressManager;
	}

}
