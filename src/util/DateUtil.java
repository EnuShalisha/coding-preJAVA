package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	/**
	 * 날짜 형식이 올바른지 확인 하는 메소드
	 * @param date 	
	 * @return
	 */
	public boolean isValidDate(String date) {
		try {
			String regex = "^\\d{4}(\\.|\\-|\\/)?\\d{2}(\\.|\\-|\\/)?\\d{2}$";
			if(! date.matches(regex)) {
				return false;
			}
			
			date = date.replaceAll("(\\-|\\.|/)", "");
			
			int y = Integer.parseInt(date.substring(0,4));
			int m = Integer.parseInt(date.substring(4,6));
			int d = Integer.parseInt(date.substring(6));
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR,y);
			cal.set(Calendar.MONTH,m-1);
			cal.set(Calendar.DATE,d);
			
			int y1=cal.get(Calendar.YEAR);
			int m1=cal.get(Calendar.MONTH)+1;
			int d1=cal.get(Calendar.DATE);
			
			if(y!=y1||m!=m1||d!=d1) {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 생년월일을 이용하여 나이를 계산하는 메소드
	 * @param birth
	 * @return
	 */
	public int toAge(String birth) {
		int age=-1;
		
		if(! isValidDate(birth)) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + birth);
		}
		
		try {
			Calendar now = Calendar.getInstance();
			
			int y = Integer.parseInt(birth.substring(0,4));
			int m = Integer.parseInt(birth.substring(4,6));
			int d = Integer.parseInt(birth.substring(6));
			
			age = now.get(Calendar.YEAR) - y;
			if((m>now.get(Calendar.MONTH)+1) || (m == now.get(Calendar.MONTH)+1 && d > now.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + birth);
		}
		
		return age;
	}

	/**
	 * String형 날짜를 Date형으로 변환하는 메소드
	 * 
	 * @param date 변환할 날짜
	 * @return 날짜
	 */
	public Date toDate(String date) {
		Date result=null;
		
		try {
			if (! isValidDate(date)) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
			}

			date = date.replaceAll("(\\-|\\.|/)", "");
			
			SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");
			result = sformat.parse(date);
			
		} catch (ParseException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	/**
	 * Date형을 String형으로 변환하는 메소드
	 * 
	 * @param date 변환할 날짜
	 * @return 변환된 문자열
	 */
	public String toString(Date date) {
		String str=null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        str = sdf.format(date);
		
		return str;
	}
	
	/**
	 * 윤년인지를 구하는 메소드
	 * @param date
	 * @return 윤년이면 true를 리턴
	 */
	public boolean isLeapYear(String date) {
		boolean b=false;
		
		try {
			if(! isValidDate(date)) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
			}
			
			date = date.replaceAll("\\-|\\.|/","");
			
			int year=Integer.parseInt(date.substring(0, 4));
			
			b = isLeapYear(year);
		} catch(IllegalArgumentException e) {
			throw e;
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
		}

		return b;
	}
	
	/**
	 * 윤년인지를 구하는 메소드
	 * @param year
	 * @return 윤년이면 true를 리턴
	 */
	public boolean isLeapYear(int year) {
		return year%4==0&&year%100!=0||year%400==0;
	}
	
	/**
	 * 두 날짜 사이의 차이(일자)를 구하는 메소드
	 * @param startDate
	 * @param endDate
	 * @return 날짜 차이(일자)
	 */
	public int toDiffDays(String startDate, String endDate) {
		int dif=0;
		
		try {
			if( (! isValidDate(startDate)) || (! isValidDate(endDate)) ){
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
			}
			
			startDate= startDate.replaceAll("\\-|\\.|/","");
			endDate= endDate.replaceAll("\\-|\\.|/","");
			
			SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");
            Date begin = sformat.parse(startDate);
    		Date end = sformat.parse(endDate);
    		dif= (int)((end.getTime() - begin.getTime()) / (1000 * 60 * 60 * 24));
    		
		} catch(ParseException e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		}

		return dif;
	}

	/**
	 * 두 날짜 사이의 차이(시간)를 구하는 메소드
	 * @param startDate
	 * @param endDate
	 * @return 날짜 차이(시간)
	 */
	public long toDiffTimes(String startDate, String endDate) {
		long dif=0;
		
		try {
			if( (! isValidDate(startDate)) || (! isValidDate(endDate)) ){
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
			}
			
			startDate= startDate.replaceAll("\\-|\\.|/","");
			endDate= endDate.replaceAll("\\-|\\.|/","");
			
			SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");
            Date begin = sformat.parse(startDate);
    		Date end = sformat.parse(endDate);
    		dif= (end.getTime() - begin.getTime()) / (1000 * 60 * 60);
    		
		} catch(ParseException e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd)");
		}

		return dif;
	}
	
	/**
	 * 기준날짜의 며칠째 되는 날을 구하는 메소드
	 * @param date 기준날짜
	 * @param days 며칠째 되는 날을 계산할 일자
	 * @return 며칠후의 날짜(yyyyMMdd)
	 */
	public String toDaysLater(String date, int days) {
		String result = null;
		try {
			if( ! isValidDate(date) ) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
			}
			
			date = date.replaceAll("\\-|\\.|/","");

			int year = Integer.parseInt(date.substring(0,4));
			int month = Integer.parseInt(date.substring(4,6));
			int day = Integer.parseInt(date.substring(6,8));
			
			Calendar cal = Calendar.getInstance();
			cal.set(year, month-1, day);
			cal.add(Calendar.DATE, days);
			
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			day = cal.get(Calendar.DATE);
			
			result = String.format("%4d-%02d-%02d", year, month, day) ;
    		
		} catch(IllegalArgumentException e) {
			throw e;
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): "+date);
		}
		
		return result;
	}
	
	/**
	 * 한 주의 시작일(일요일)을 구하는 메소드
	 * @param date
	 * @return 한 주의 시작일자(yyyyMMdd)
	 */
	public String toWeekStart(String date) {
		String result = null;
		try {
			if(! isValidDate(date) ) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
			}
			
			date = date.replaceAll("\\-|\\.|/","");
			
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6));
			
			Calendar cal = Calendar.getInstance ();
		    cal.set(Calendar.YEAR, year);
		    cal.set(Calendar.MONTH, month-1);
		    cal.set(Calendar.DATE, day);
		    
		    cal.set(Calendar.DAY_OF_WEEK, 1); // 요일을 일요일로 설정
		    
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			day = cal.get(Calendar.DATE);
			
			result = String.format("%4d-%02d-%02d", year, month, day) ;
			
		} catch(IllegalArgumentException e) {
			throw e;
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
		}

		return result;
	}
	
	/**
	 * 한 주의 마지막일(토요일)을 구하는 메소드
	 * @param date
	 * @return 한 주의 마지막일자(yyyy-MM-dd)
	 */
	public String toWeekEnd(String date) {
		String result=null;
		try {
			if( ! isValidDate(date) ) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
			}
			
			date = date.replaceAll("\\-|\\.|/","");
			
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6));
			
			Calendar cal = Calendar.getInstance ();
		    cal.set(Calendar.YEAR, year);
		    cal.set(Calendar.MONTH, month-1);
		    cal.set(Calendar.DATE, day);
		    
		    cal.set(Calendar.DAY_OF_WEEK, 7); // 요일을 토요일로 설정
		    
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			day = cal.get(Calendar.DATE);
			
			result = String.format("%4d-%02d-%02d", year, month, day) ;
			
		} catch(IllegalArgumentException e) {
			throw e;
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
		}

		return result;
	}
	
	/**
	 * 특정날짜의 다음날짜를 구하는 메소드
	 * @param date 다음날짜를 구할 날짜
	 * @return 특정날짜의 다음날짜 리턴 (yyyy-MM-dd)
	 */
    public String afterDays(String date) {
        String result = null;
        
        try {
			if( ! isValidDate(date) ) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
			}
			
			date = date.replaceAll("\\-|\\.|/","");
	        
	        Calendar cal = Calendar.getInstance();
	        cal.set(Integer.parseInt(date.substring(0,4)), Integer.parseInt(date.substring(4,6))-1, Integer.parseInt(date.substring(6,8)));

	        cal.add(Calendar.DATE, +1);

	        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd", Locale.KOREA);
	        result = formatter.format (cal.getTime());
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
		}        

         return result;
    }

    /**
     * 특정날짜의 이전날짜를 구하는 메소드
     * @param date 이전날짜를 구할 날짜
     * @return 특정날짜의 이전날짜 리턴 (yyyy-MM-dd)
     */
    public String preDays(String date) {
        String result = null;

		try {
			if(! isValidDate(date)) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
			}
			
			date = date.replaceAll("\\-|\\.|/","");
			
	        Calendar cal = Calendar.getInstance();

	        cal.set(Integer.parseInt(date.substring(0,4)), Integer.parseInt(date.substring(4,6))-1, Integer.parseInt(date.substring(6,8)));
	        cal.add(Calendar.DATE, -1);

	        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd", Locale.KOREA);
	        result = formatter.format (cal.getTime());
			
		} catch(IllegalArgumentException e) {
			throw e;
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + date);
		}

        return result;
    }
    
    /**
     * 해당년도의 띠를 구하는 메소드
     * @param birth
     * @return
     */
    public String toTti(String birth) {
		String s="";
		try {
			if(! isValidDate(birth)) {
				throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + birth);
			}
			
			birth = birth.replaceAll("\\-|\\.|/","");
			
			int year = Integer.parseInt(birth.substring(0, 4));
			s = toTti(year);
			
		} catch(IllegalArgumentException e) {
			throw e;
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid date format(yyyyMMdd, yyyy-MM-dd): " + birth);
		}

		return s;
    }
    
    /**
     * 해당년도의 띠를 구하는 메소드
     * @param year
     * @return
     */
    public String toTti(int year) {
		String t[] = {"원숭이", "닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
    	return t[year%12];
    }
	
	/**
	 * 주민번호가 올바른 형식인지를 리턴하는 메소드(올바르면 true)
	 * 
	 * @param rrn  주민번호
	 * @return      
	 */
	public boolean isValidRrn(String rrn) {
		int [] check = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int tot, n, lastNum, chkNum;
		boolean b=false;
		
		try {
			if (rrn.length() != 14 && rrn.length() != 13) {
				return false;
			}
			
			if(toBirth(rrn).length()==0) {
				return false;
			}

			rrn = rrn.replaceAll("-", "");

			tot=0;
			for(int i = 0; i < 12; i++) {
				n = Integer.parseInt(rrn.substring(i, i+1));

				tot = tot+(n * check[i]);
			}

			lastNum = Integer.parseInt(rrn.substring(12));
			chkNum = 11 - tot % 11;
			chkNum = chkNum % 10;
			
			b = lastNum == chkNum;
			
		} catch (Exception e) {
			return false;
		}

		return b;
	}
	
	/**
	 * 주민번호를 이용하여 생년월일을 리턴하는 메소드
	 * 
	 * @param rrn  주민번호
	 * @return     생년월일
	 */
	public String toBirth(String rrn) {
		String birth="";
		int gender;
		
		try {
			if (rrn.length() != 14 && rrn.length() != 13) {
				throw new IllegalArgumentException("Invalid rrn format: " + rrn);
			}
			
			rrn = rrn.replaceAll("-", "");
			gender=Integer.parseInt(rrn.substring(6,7));
			
			// birth=rrn.substring(0, 6);
			birth=rrn.substring(0, 2)+"-"+rrn.substring(2, 4)+"-"+rrn.substring(4, 6);
			if(gender==1||gender==2||gender==5||gender==6) {
				birth="19"+birth;
			} else if(gender==3||gender==4||gender==7||gender==8) {
				birth="20"+birth;
			} else if(gender==0||gender==9) {
				birth="18"+birth;
			}
			
			if(! isValidDate(birth)) {
				throw new IllegalArgumentException("Invalid rrn format: " + rrn);
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return birth;
	}
	
	/**
	 * 주민번호를 이용하여 성별을 리턴하는 메소드
	 * 
	 * @param rrn  주민번호
	 * @return     성별
	 */
	public String toGender(String rrn) {
		String gender=null;
		int s;
		
		try {
			if (rrn.length() != 14 && rrn.length() != 13) {
				throw new IllegalArgumentException("Invalid rrn format: " + rrn);
			}
			
			rrn = rrn.replaceAll("-", "");
			s = Integer.parseInt(rrn.substring(6,7));
			
			gender = s%2==1 ? "남자":"여자";
			
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return gender;
	}
	
}
