package org.ahmeteminsaglik.searchnode.business.abstracts.searchnode.subservices.node;

import org.ahmeteminsaglik.searchnode.entities.NodeData;

import java.util.List;

public interface SNSNodeRead<T> {

    NodeData<T> searchNodeData(String text);

    List<NodeData<T>> getAllNodeData(String text);
}
