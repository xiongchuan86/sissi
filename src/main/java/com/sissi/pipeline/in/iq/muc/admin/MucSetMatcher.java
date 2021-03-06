package com.sissi.pipeline.in.iq.muc.admin;

import com.sissi.context.JIDBuilder;
import com.sissi.pipeline.in.MucMatcher;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.ProtocolType;
import com.sissi.protocol.muc.XMucAdmin;

/**
 * <iq type="set"><query xmlns='http://jabber.org/protocol/muc#admin'><item item='xxx'/affiliation='xxxx'/></query></iq>
 * 
 * @author kim 2014年3月14日
 */
public class MucSetMatcher extends MucMatcher {

	public MucSetMatcher(JIDBuilder jidBuilder) {
		super(XMucAdmin.class, jidBuilder);
	}

	public boolean match(Protocol protocol) {
		return super.match(protocol) && protocol.parent().type(ProtocolType.SET) && protocol.cast(XMucAdmin.class).item();
	}
}
