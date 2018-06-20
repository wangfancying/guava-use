package com.wanghui.guava.multi;

import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Table它有两个支持所有类型的键：”行”和”列”。
 *
 * @author hui.wang
 * @since 19 六月 2018
 */
public class TableUse {

	public static void main(String[] args) {
		//记录学生在某门课上的成绩
		Table<String, String, Integer> table = HashBasedTable.create();
		table.put("jack", "java", 100);
		table.put("jack", "c", 90);
		table.put("mike", "java", 93);
		table.put("mike", "c", 100);
		Set<Table.Cell<String, String, Integer>> cells = table.cellSet();
		for (Table.Cell<String, String, Integer> cell : cells) {
			System.out.println(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
		}
		System.out.println(table.row("jack"));
		System.out.println(table);
		System.out.println(table.rowKeySet());
		System.out.println(table.columnKeySet());
		System.out.println(table.values());
	}
}
