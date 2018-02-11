package cpm.babayetu.lucode;

import java.util.List;

public interface Processor<T> {
	void process(List<T> input);
}
