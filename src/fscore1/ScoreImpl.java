package fscore1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
	private List<ScoreVO> list=new ArrayList<ScoreVO>();
	private String pathname="score1.txt";
	
	public ScoreImpl() {
		loadFile();
	}
	
	private void loadFile() {
		File f=new File(pathname);
		
		if(! f.exists()) { // 파일이 없으면
			return;
		}
		// 문자 입력 스트림: Reader, BufferedReader(filtered), filereader
		//byte->문자 변환해야 사용가능 스트림: Reader, BufferedReader / by InputStreamReader
		//FileReader를 쓰면 문자로 변환하지 않고 바로 input 가능
		// FileReader : 파일 문자 스트림 cf. Fileinputsystem: 파일을 받아 byte 입력 스트림
		try(BufferedReader br=new BufferedReader(new FileReader(f))) {
			String s;
			// 1001,홍길동,100,100,100
			while((s=br.readLine())!=null) {
				String[]ss=s.split(",");
				if(ss.length!=5)
					continue;
				
				ScoreVO vo=new ScoreVO();
				vo.setHak(ss[0]);
				vo.setName(ss[1]);
				vo.setKor(Integer.parseInt(ss[2]));
				vo.setEng(Integer.parseInt(ss[3]));
				vo.setMat(Integer.parseInt(ss[4]));
				
				// 파일 내용을 읽어 ArrayList에 저장
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void insertScore(ScoreVO vo) throws DuplicationException {
		if(readScore(vo.getHak())!=null)
			throw new DuplicationException("학번 중복 오류 !!!");
		
		list.add(vo);
	}

	@Override
	public boolean deleteScore(String hak) {
		ScoreVO vo=readScore(hak);
		if(vo==null)
			return false;
		
		list.remove(vo);
		
		return true;
	}

	@Override
	public List<ScoreVO> listScore() {
		return list;
	}

	@Override
	public ScoreVO readScore(String hak) {
		ScoreVO vo=null;
		for(ScoreVO vv:list) {
			if(vv.getHak().equals(hak)) {
				vo=vv;
				break;
			}
		}
		return vo;
	}

	@Override
	public void saveFile() {
		File f=new File(pathname);
		//원래 byte 스트림이나 텍스트 파일에 한해서 편하게 저장 가능
		try(PrintStream ps=new PrintStream(f)) {
			// ArrayList 내용을 파일로 저장
			for(ScoreVO vo:list) {
				ps.print(vo.getHak()+",");
				ps.print(vo.getName()+",");
				ps.print(vo.getKor()+",");
				ps.print(vo.getEng()+",");
				ps.print(vo.getMat()+"\n");
			}
			System.out.println("파일 저장 완료 !!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
