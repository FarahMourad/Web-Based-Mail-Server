import Vue from 'vue'
import Router from 'vue-router'
import SignUp from '@/components/SignUp'
import SignIn from '@/components/Hedwig'
import Mail from '@/components/Mail'
import Account from '@/components/Account'



Vue.use(Router)

export default new Router({
    routes: [
    {
        path: '/SignUp',
        name: 'SignUp',
        component: SignUp
    },
    {
        path: '/',
        name: 'SignIn',
        component: SignIn
    },
    {
        path: '/mail/:id',
        name: 'mail',
        component: Mail
    },
    {
        path: '/account/:id',
        name: 'account',
        component: Account
    },
    ]

})