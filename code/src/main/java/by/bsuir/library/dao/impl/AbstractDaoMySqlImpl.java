package by.bsuir.library.dao.impl;

import by.bsuir.library.dao.util.WrapMySqlConnect;

abstract class AbstractDaoMySqlImpl {
	
	protected static final String SQL_USER = "user";
    protected static final String SQL_BOOK = "book";
    protected static final String SQL_AUTHOR = "author";
    protected static final String SQL_BOOKING = "booking";
    protected static final String SQL_ORDER = "order";

    protected static final String SQL_ID = "id";
    protected static final String SQL_NAME = "name";

    protected static final String SQL_USER_SURNAME = "surname";
    protected static final String SQL_USER_PASSWORD = "password";
    protected static final String SQL_USER_LOGIN = "login";
    protected static final String SQL_USER_EMAIL = "email";
    protected static final String SQL_USER_ROLE = "role";

    protected static final String SQL_BOOK_AUTHOR_ID = "authorId";
    protected static final String SQL_BOOK_AMOUNT = "amount";
    protected static final String SQL_BOOK_TITLE = "title";
    protected static final String SQL_BOOK_AUTHOR = "name";

    protected static final String SQL_BOOKIND_DATE = "date_booking";
    protected static final String SQL_BOOKING_USER_ID = "user_id";
    protected static final String SQL_BOOKING_BOOK_ID = "book_id";
    protected static final String SQL_BOOKING_IS_APPROVED = "is_approved";

    protected static final String SQL_ORDER_DATE = "date_take+";
    protected static final String SQL_ORDER_IS_RETURNED = "is_returned";
    protected static final String SQL_ORDER_BOOKING_ID = "booking_id";

	WrapMySqlConnect wcn;
	{
		wcn = new WrapMySqlConnect();
	}
	
}
