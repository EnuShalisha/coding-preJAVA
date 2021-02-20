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
		
		if(! f.exists()) { // ������ ������
			return;
		}
		// ���� �Է� ��Ʈ��: Reader, BufferedReader(filtered), filereader
		//byte->���� ��ȯ�ؾ� ��밡�� ��Ʈ��: Reader, BufferedReader / by InputStreamReader
		//FileReader�� ���� ���ڷ� ��ȯ���� �ʰ� �ٷ� input ����
		// FileReader : ���� ���� ��Ʈ�� cf. Fileinputsystem: ������ �޾� byte �Է� ��Ʈ��
		try(BufferedReader br=new BufferedReader(new FileReader(f))) {
			String s;
			// 1001,ȫ�浿,100,100,100
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
				
				// ���� ������ �о� ArrayList�� ����
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void insertScore(ScoreVO vo) throws DuplicationException {
		if(readScore(vo.getHak())!=null)
			throw new DuplicationException("�й� �ߺ� ���� !!!");
		
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
		//���� byte ��Ʈ���̳� �ؽ�Ʈ ���Ͽ� ���ؼ� ���ϰ� ���� ����
		try(PrintStream ps=new PrintStream(f)) {
			// ArrayList ������ ���Ϸ� ����
			for(ScoreVO vo:list) {
				ps.print(vo.getHak()+",");
				ps.print(vo.getName()+",");
				ps.print(vo.getKor()+",");
				ps.print(vo.getEng()+",");
				ps.print(vo.getMat()+"\n");
			}
			System.out.println("���� ���� �Ϸ� !!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
