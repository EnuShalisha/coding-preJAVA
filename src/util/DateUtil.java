package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	/**
	 * ��¥ ������ �ùٸ��� Ȯ�� �ϴ� �޼ҵ�
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
	 * ��������� �̿��Ͽ� ���̸� ����ϴ� �޼ҵ�
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
	 * String�� ��¥�� Date������ ��ȯ�ϴ� �޼ҵ�
	 * 
	 * @param date ��ȯ�� ��¥
	 * @return ��¥
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
	 * Date���� String������ ��ȯ�ϴ� �޼ҵ�
	 * 
	 * @param date ��ȯ�� ��¥
	 * @return ��ȯ�� ���ڿ�
	 */
	public String toString(Date date) {
		String str=null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        str = sdf.format(date);
		
		return str;
	}
	
	/**
	 * ���������� ���ϴ� �޼ҵ�
	 * @param date
	 * @return �����̸� true�� ����
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
	 * ���������� ���ϴ� �޼ҵ�
	 * @param year
	 * @return �����̸� true�� ����
	 */
	public boolean isLeapYear(int year) {
		return year%4==0&&year%100!=0||year%400==0;
	}
	
	/**
	 * �� ��¥ ������ ����(����)�� ���ϴ� �޼ҵ�
	 * @param startDate
	 * @param endDate
	 * @return ��¥ ����(����)
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
	 * �� ��¥ ������ ����(�ð�)�� ���ϴ� �޼ҵ�
	 * @param startDate
	 * @param endDate
	 * @return ��¥ ����(�ð�)
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
	 * ���س�¥�� ��ĥ° �Ǵ� ���� ���ϴ� �޼ҵ�
	 * @param date ���س�¥
	 * @param days ��ĥ° �Ǵ� ���� ����� ����
	 * @return ��ĥ���� ��¥(yyyyMMdd)
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
	 * �� ���� ������(�Ͽ���)�� ���ϴ� �޼ҵ�
	 * @param date
	 * @return �� ���� ��������(yyyyMMdd)
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
		    
		    cal.set(Calendar.DAY_OF_WEEK, 1); // ������ �Ͽ��Ϸ� ����
		    
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
	 * �� ���� ��������(�����)�� ���ϴ� �޼ҵ�
	 * @param date
	 * @return �� ���� ����������(yyyy-MM-dd)
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
		    
		    cal.set(Calendar.DAY_OF_WEEK, 7); // ������ ����Ϸ� ����
		    
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
	 * Ư����¥�� ������¥�� ���ϴ� �޼ҵ�
	 * @param date ������¥�� ���� ��¥
	 * @return Ư����¥�� ������¥ ���� (yyyy-MM-dd)
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
     * Ư����¥�� ������¥�� ���ϴ� �޼ҵ�
     * @param date ������¥�� ���� ��¥
     * @return Ư����¥�� ������¥ ���� (yyyy-MM-dd)
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
     * �ش�⵵�� �츦 ���ϴ� �޼ҵ�
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
     * �ش�⵵�� �츦 ���ϴ� �޼ҵ�
     * @param year
     * @return
     */
    public String toTti(int year) {
		String t[] = {"������", "��","��","����","��","��","ȣ����","�䳢","��","��","��","��"};
    	return t[year%12];
    }
	
	/**
	 * �ֹι�ȣ�� �ùٸ� ���������� �����ϴ� �޼ҵ�(�ùٸ��� true)
	 * 
	 * @param rrn  �ֹι�ȣ
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
	 * �ֹι�ȣ�� �̿��Ͽ� ��������� �����ϴ� �޼ҵ�
	 * 
	 * @param rrn  �ֹι�ȣ
	 * @return     �������
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
	 * �ֹι�ȣ�� �̿��Ͽ� ������ �����ϴ� �޼ҵ�
	 * 
	 * @param rrn  �ֹι�ȣ
	 * @return     ����
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
			
			gender = s%2==1 ? "����":"����";
			
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return gender;
	}
	
}
