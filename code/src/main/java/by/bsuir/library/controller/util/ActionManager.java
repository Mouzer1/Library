package by.bsuir.library.controller.util;

import static by.bsuir.library.controller.util.ControllerConstantPool.*;

import by.bsuir.library.bean.User;
import by.bsuir.library.controller.action.BaseAction;
import by.bsuir.library.controller.action.impl.AcceptBookingImpl;
import by.bsuir.library.controller.action.impl.BookBookImpl;
import by.bsuir.library.controller.action.impl.CancelBookingImpl;
import by.bsuir.library.controller.action.impl.CheckLoginImpl;
import by.bsuir.library.controller.action.impl.CreateBookImpl;
import by.bsuir.library.controller.action.impl.DefaultActionImpl;
import by.bsuir.library.controller.action.impl.DeleteBookImpl;
import by.bsuir.library.controller.action.impl.MakeOrderImpl;
import by.bsuir.library.controller.action.impl.PrepareUpdateImpl;
import by.bsuir.library.controller.action.impl.RegistrationImpl;
import by.bsuir.library.controller.action.impl.RejectBookingImpl;
import by.bsuir.library.controller.action.impl.ReturnBookImpl;
import by.bsuir.library.controller.action.impl.SearchBookImpl;
import by.bsuir.library.controller.action.impl.ShowActiveBookingsImpl;
import by.bsuir.library.controller.action.impl.ShowActiveOrders;
import by.bsuir.library.controller.action.impl.ShowBookListAdminImpl;
import by.bsuir.library.controller.action.impl.ShowBookListImpl;
import by.bsuir.library.controller.action.impl.ShowBookingsHistoryImpl;
import by.bsuir.library.controller.action.impl.ShowNewBookingsImpl;
import by.bsuir.library.controller.action.impl.ShowOrdersHistoryImpl;
import by.bsuir.library.controller.action.impl.ShowUserListImpl;
import by.bsuir.library.controller.action.impl.UpdateBookImpl;

public class ActionManager {
	
	private ActionManager() {}
	
	public static BaseAction determineAction(String action) {
		BaseAction act = null;
		User current;
		
		switch(action) {
        case  REQUEST_PARAM_SIGN_IN:
            act = new CheckLoginImpl();
            break;
            
        case REQUEST_PARAM_SIGN_UP:
        	act = new RegistrationImpl();
        	break;
        	
        case REQUEST_PARAM_SHOW_BOOK_LIST:
        	act = new ShowBookListImpl();
        	break;
        	
        case REQUEST_PARAM_BOOK_BOOK:
        	act = new BookBookImpl();
        	break;
        	
        case REQUEST_PARAM_SEARCH_BOOK:
        	act = new SearchBookImpl();
        	break;
        	
        case REQUEST_PARAM_SHOW_ORDERS_HISTORY:
        	act = new ShowOrdersHistoryImpl();
        	break;
        	
        case REQUEST_PARAM_SHOW_BOOKINGSS_HISTORY:
        	act = new ShowBookingsHistoryImpl();
        	break;
        	
        case REQUEST_PARAM_CANCEL_BOOKING:
        	act = new CancelBookingImpl();
        	break;
        	
        case REQUEST_PARAM_SHOW_BOOK_LIST_ADMIN:
        	act = new ShowBookListAdminImpl();
        	break;
        	
        case REQUEST_PARAM_DELETE_BOOK:
        	act = new DeleteBookImpl();
        	break;
        	
        case REQUEST_PARAM_CREATE_BOOK:
        	act = new CreateBookImpl();
        	break;
        	
        case REQUEST_PARAM_SHOW_USER_LIST:
        	act = new ShowUserListImpl();
        	break;
        	
        case REQUEST_PARAM_SHOW_NEW_BOOKINGS:
        	act = new ShowNewBookingsImpl();
        	break;
        	
        case REQUEST_PARAM_SHOW_ACTIVE_BOOKINGS:
        	act = new ShowActiveBookingsImpl();
        	break;
        	
        case REQUEST_PARAM_SHOW_ACTIVE_ORDERS:
        	act = new ShowActiveOrders();
        	break;
        	
        case REQUEST_PARAM_ACCEPT_BOOKING:
        	act = new AcceptBookingImpl();
        	break;
        	
        case REQUEST_PARAM_REJECT_BOOKING:
        	act = new RejectBookingImpl();
        	break;
        	
        case REQUEST_PARAM_WAS_RETURNED:
        	act = new ReturnBookImpl();
        	break;
        	
        case REQUEST_PARAM_MAKE_ORDER:
        	act = new MakeOrderImpl();
        	break;
       
    }
    return act;
}
//		case REQUEST_PARAM_BOOK_LIST:
//			act = new ShowBookListImpl();
//			break;
//		case REQUEST_PARAM_SEARCH_BOOK:
//			act = new SearchBookImpl();
//			break;
//		case REQUEST_PARAM_CREATE_BOOK:
//			act = new CreateBookImpl();
//			break;
//		case REQUEST_PARAM_DELETE_BOOK:
//			act = new DeleteBookImpl();
//			break;
//		case REQUEST_PARAM_UPDATE_BOOK:
//			act = new PrepareUpdateImpl();
//			break;
//		case REQUEST_PARAM_UPDATE_BOOK_SECOND:
//			act = new UpdateBookImpl();
//			break;
//		case REQUEST_PARAM_SHOW_USERS:
//			act = new ShowBookListImpl();
//			break;
//		default:
//			act = new DefaultActionImpl();
//		}
//		return act;
//	}

}
