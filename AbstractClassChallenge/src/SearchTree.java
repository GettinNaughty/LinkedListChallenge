
public class SearchTree implements NodeList {
	private ListItem root = null;
	
	public SearchTree(ListItem root) {
		super();
		this.root = root;
	}

	@Override
	public ListItem getRoot() {
		// TODO Auto-generated method stub
		return this.root;
	}

	@Override
	public boolean addItem(ListItem newItem) {
		if(this.root == null) {
			this.root = newItem;
			return true;
		}
		ListItem currentItem = this.root;
		while(currentItem != null) {
			int comparison = currentItem.compareTo(newItem);
			if(comparison<0) {
				if(currentItem.next()!= null) {
					currentItem = currentItem.next();
				}
				else {
					currentItem.setNext(newItem);
					return true;
				}
			}
			else if(comparison>0) {
				if(currentItem.previous() != null) {
					currentItem = currentItem.previous();
					
				}
				else {
					currentItem.setPrevious(newItem);
				}
				return true;
			}
			else {
				System.out.println(newItem.getValue() + " is already present, not added.");
				return false;
			}
		}
		return false;
		
	}

	@Override
	public boolean removeItem(ListItem item) {
		if(item != null) {
			System.out.println("Deleting item: "+ item.getValue());
		}
		ListItem currentItem = this.root;
		ListItem parentItem = currentItem;
		while(currentItem != null) {
			int comparison= currentItem.compareTo(item);
			if(comparison<0) {
				parentItem = currentItem;
				currentItem = currentItem.next();
			}
			else if(comparison >0) {
				parentItem = currentItem;
				currentItem = currentItem.previous();
			}
			else {
				performRemoval(parentItem,currentItem);
				return true;
			}
		}
		return false;	
	}
	private void performRemoval(ListItem parentItem, ListItem currentItem) {
		if(currentItem.next() == null) {
			if(parentItem.next() == currentItem) {
				parentItem.setNext(currentItem.previous());
			}
			else if(parentItem.previous() == currentItem) {
				parentItem.setPrevious(currentItem.previous());
			}
			else {
				this.root = currentItem.previous();
			}
		}
		else if(currentItem.previous() == null) {
			if(parentItem.next() == currentItem) {
				parentItem.setNext(currentItem.next());
			}
			else if(parentItem.previous() == currentItem) {
				parentItem.setPrevious(currentItem.next());
			}
			else {
				this.root = currentItem.previous();
			}
		}
		else {
			ListItem current = currentItem.next();
			ListItem leftMostParent = currentItem;
			while(current.previous() !=null) {
				leftMostParent = current;
				current = current.previous();
			}
			currentItem.setValue(current.getValue());
			if(leftMostParent == currentItem) {
				currentItem.setNext(current.next());
				
			}
			else {
				leftMostParent.setPrevious(current.next());
			}
		}
	}
	@Override
	public void transverse(ListItem root) {
		// TODO Auto-generated method stub
		if(root!= null) {
			transverse(root.previous());
			System.out.println(root.getValue());
			transverse(root.next());
		}
	}

}
