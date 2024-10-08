package jadx.tests.integration.others;

import java.util.List;

import org.junit.jupiter.api.Test;

import jadx.core.dex.nodes.ClassNode;
import jadx.tests.api.SmaliTest;

import static jadx.tests.api.utils.assertj.JadxAssertions.assertThat;

public class TestFixClassAccessModifiers extends SmaliTest {
	// @formatter:off
	/*
		// class others.TestCls
		public Cls.InnerCls field;

		// class others.Cls
		public static class Cls {
			private static class InnerCls {
			}
		}
	*/
	// @formatter:on

	@Test
	public void test() {
		List<ClassNode> classes = loadFromSmaliFiles();
		assertThat(searchCls(classes, "others.Cls"))
				.code();
	}
}
