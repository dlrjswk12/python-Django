package ch01_fundamental;

public class EntryVO {
	private String name;
	private String etcs;
		
	public EntryVO(String name, String etcs) {
		this.name = name;
		this.etcs = etcs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEtcs() {
		return etcs;
	}

	public void setEtcs(String etcs) {
		this.etcs = etcs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etcs == null) ? 0 : etcs.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntryVO other = (EntryVO) obj;
		if (etcs == null) {
			if (other.etcs != null)
				return false;
		} else if (!etcs.equals(other.etcs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
