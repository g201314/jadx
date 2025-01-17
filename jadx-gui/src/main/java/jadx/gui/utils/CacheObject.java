package jadx.gui.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

import jadx.api.JavaClass;
import jadx.gui.JadxWrapper;
import jadx.gui.ui.dialog.SearchDialog;
import jadx.gui.utils.pkgs.PackageHelper;

public class CacheObject {
	private final JadxWrapper wrapper;

	private String lastSearch;
	private JNodeCache jNodeCache;
	private Map<SearchDialog.SearchPreset, Set<SearchDialog.SearchOptions>> lastSearchOptions;
	private String lastSearchPackage;

	private List<List<JavaClass>> decompileBatches;
	private PackageHelper packageHelper;

	private volatile boolean fullDecompilationFinished;

	public CacheObject(JadxWrapper wrapper) {
		this.wrapper = wrapper;
		reset();
	}

	public void reset() {
		lastSearch = null;
		jNodeCache = new JNodeCache(wrapper);
		lastSearchOptions = new HashMap<>();
		lastSearchPackage = null;
		decompileBatches = null;
		packageHelper = null;
		fullDecompilationFinished = false;
	}

	@Nullable
	public String getLastSearch() {
		return lastSearch;
	}

	@Nullable
	public String getLastSearchPackage() {
		return lastSearchPackage;
	}

	public void setLastSearch(String lastSearch) {
		this.lastSearch = lastSearch;
	}

	public void setLastSearchPackage(String lastSearchPackage) {
		this.lastSearchPackage = lastSearchPackage;
	}

	public JNodeCache getNodeCache() {
		return jNodeCache;
	}

	public Map<SearchDialog.SearchPreset, Set<SearchDialog.SearchOptions>> getLastSearchOptions() {
		return lastSearchOptions;
	}

	public @Nullable List<List<JavaClass>> getDecompileBatches() {
		return decompileBatches;
	}

	public void setDecompileBatches(List<List<JavaClass>> decompileBatches) {
		this.decompileBatches = decompileBatches;
	}

	public PackageHelper getPackageHelper() {
		return packageHelper;
	}

	public void setPackageHelper(PackageHelper packageHelper) {
		this.packageHelper = packageHelper;
	}

	public boolean isFullDecompilationFinished() {
		return fullDecompilationFinished;
	}

	public void setFullDecompilationFinished(boolean fullDecompilationFinished) {
		this.fullDecompilationFinished = fullDecompilationFinished;
	}
}
