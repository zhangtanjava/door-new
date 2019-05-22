package com.gx.po;

public class WlStore {
    private String model;

    private String size;

    private Integer outLeft = 0;

    private Integer outRight = 0;

    private Integer id;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }


	public Integer getOutLeft() {
		return outLeft;
	}

	public void setOutLeft(Integer outLeft) {
		this.outLeft = outLeft;
	}

	public Integer getOutRight() {
		return outRight;
	}

	public void setOutRight(Integer outRight) {
		this.outRight = outRight;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "WlStore [model=" + model + ", size=" + size + ", outLeft=" + outLeft + ", outRight=" + outRight
				+ ", id=" + id + "]";
	}
}