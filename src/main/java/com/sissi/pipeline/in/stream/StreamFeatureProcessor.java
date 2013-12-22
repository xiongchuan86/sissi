package com.sissi.pipeline.in.stream;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.Stream;
import com.sissi.protocol.feature.Bind;
import com.sissi.protocol.feature.Mechanisms;
import com.sissi.protocol.feature.Register;
import com.sissi.protocol.feature.Session;

/**
 * @author kim 2013-10-24
 */
public class StreamFeatureProcessor implements Input {

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		if (context.isAuth()) {
			this.buildBindingFeature(Stream.class.cast(protocol));
		} else {
			this.buildLoginMethod(context, Stream.class.cast(protocol));
		}
		return true;
	}

	private Protocol buildLoginMethod(JIDContext context, Stream stream) {
		return stream.addFeature(Mechanisms.FEATURE).addFeature(Register.FEATURE);
	}

	private Protocol buildBindingFeature(Stream stream) {
		return stream.addFeature(Session.FEATURE).addFeature(Bind.FEATURE);

	}
}