package com.WebOfNVD.Common.Convert;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

public class JMapperConvert<D, S> {
	JMapper<?, ?> realMapper;
// JMapper simpleMapper;
	Class<D> classD;
	Class<S> classS;

	public JMapperConvert(Class<D> d, Class<S> s) {
		JMapperAPI api = new JMapperAPI().add(JMapperAPI.mappedClass(s));
		realMapper = new JMapper<>(d, s, api);
	}
}
