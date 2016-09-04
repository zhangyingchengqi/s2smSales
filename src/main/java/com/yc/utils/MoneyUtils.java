package com.yc.utils;

public class MoneyUtils {
	private static final String unit = "��Ǫ��ʰ��Ǫ��ʰ��Ǫ��ʰԪ�Ƿ�";
	private static final String digit = "��Ҽ��������½��ƾ�";
	private static final double MAX_VALUE = 9999999999999.99D;
	
	public static void main(String[] args){
		System.out.println( MoneyUtils.change(123.34) );
	}

	public static String change(double v) {
		if (v < 0 || v > MAX_VALUE) {
			return "�����Ƿ�!";
		}
		long l = Math.round(v * 100);   //   12034
		if (l == 0) {
			return "��Ԫ��";
		}
		String strValue = l + "";
		// i����������
		int i = 0;
		// j�������Ƶ�λ
		int j = unit.length() - strValue.length();  //15-5   => 10
		String rs = "";
		boolean isZero = false;
		for (; i < strValue.length(); i++, j++) {
			char ch = strValue.charAt(i);   //1  '2' '0'
			if (ch == '0') {
				isZero = true;
				if (unit.charAt(j) == '��' || unit.charAt(j) == '��' || unit.charAt(j) == 'Ԫ') {
					rs = rs + unit.charAt(j);  // Ҽ�ٷ�ʰԪ
				}
			} else {
				if (isZero) {
					rs = rs + "��";
					isZero = false;
				}
				rs = rs + digit.charAt(ch - '0') + unit.charAt(j);  // Ҽ�ٷ�ʰԪ����
			}
		}
		if (!rs.endsWith("��")) {
			rs = rs + "��";
		}
		rs = rs.replaceAll("����", "��");
		return rs;
	}
}
