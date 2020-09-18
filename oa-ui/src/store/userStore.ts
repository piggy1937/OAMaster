import {observable, action} from 'mobx'

class UserStore {

    @observable name:string = "sun"

    @action
    changeName():void {
        if (this.name === "sun") {
            this.name = "wen"
        } else {
            this.name = "sun"
        }
    }
}

export default UserStore;